from imutils.object_detection import non_max_suppression
import numpy as np
import pytesseract
import argparse
import cv2
from PIL import Image, ImageFilter, ImageEnhance
import tempfile
import re
import io
import pandas as pd
import json
from flask import jsonify
def set_image_dpi(file_path):
    im = Image.open(io.BytesIO(file_path))
    length_x, width_y = im.size
    factor = min(1, float(1024.0 / length_x))
    size = int(factor * length_x), int(factor * width_y)
    im_resized = im.resize(size, Image.ANTIALIAS)
    temp_file = tempfile.NamedTemporaryFile(delete=False,   suffix='.jpeg')
    temp_filename = temp_file.name
    im_resized.save(temp_filename, dpi=(300, 300))
    return temp_filename
def get_diagonsitics(medical_file):
    f = open(medical_file, "r")
    m=str(f.read())
    # a=""
    # print(type(a))
    # for x in m.split():
    #     a=a+"\n"+ x
    # print(a)
    return m.lower()
    # return a.lower()
def get_data(file_dir,m):
    dic={
    'General Diary Reference':'556',
    'Place of Occurrence(a) Direction and Distance from PS':'Layekdi South Side about 12 km ',
    '(a) Address':'ANCHAL NO- VI VILLAGE LAYEKHI PS- CHHATNA DISTRICT BANKHRA',
    '(a) Name ':'BIPLAB MANDI',
    '(B) Father Name':'DHARAM DAS MANDI',
    'Fir contents':'THE ORGINALL WRITTEN COMPLIANT WHICH IS TREATED AS FIR AND ATTACHED HERE WITH',
    'Action taken:Since the above report reveals comission of offence(s)':'135(1)(b) OF THE ELECTRICITY AMENDENMENT ACT 2007'
    }
    # df=pd.DataFrame(dic)
    r=json.dumps(dic)
    u=json.loads(r)
    return u
