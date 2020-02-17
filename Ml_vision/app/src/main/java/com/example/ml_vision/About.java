package com.example.ml_vision;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;

import com.mikhaellopez.circularimageview.CircularImageView;

public class About extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("About");
        setContentView(R.layout.activity_about);
        ActionBar toolbar = getSupportActionBar();
        assert toolbar != null;
        toolbar.setElevation(0);
        CircularImageView circularImageView = findViewById(R.id.cimg);
        circularImageView.setCircleColor(Color.WHITE);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.WHITE);
        circularImageView.setShadowEnable(false);
    }
}
