package com.example.ml_vision;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity
{
    ImageView logo;
    static int splashTimeOut = 1700;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_bkg);
        logo =findViewById(R.id.logo);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash_Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        },splashTimeOut);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        logo.startAnimation(animation);
    }
}
