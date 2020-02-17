package com.example.ml_vision;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RetrofitClientInstance
{
    String BASE_URL = "http://192.168.175.231:5000/" ;

    @Multipart
    @POST("/ocr")
    Call<HashMap<String,String>> upload(@Part MultipartBody.Part imageFile,
                         @Part("description") RequestBody description
                );

}
