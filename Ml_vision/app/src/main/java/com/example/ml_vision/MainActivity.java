package com.example.ml_vision;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
{

    EditText username,password ;
    private LoginButton loginButton;
    CallbackManager callbackManager;

    public void startActivity(View view)
    {
        String name=username.getText().toString();
        String pass=password.getText().toString();
        if(name.equals("admin")&&pass.equals("admin"))
        {
            Intent intent=new Intent(MainActivity.this, BaseActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
        else if(name.equals("")||pass.equals(""))
        {
            Toast.makeText(this, "Please input data for the fields", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "Wrong details entered!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        loginButton = findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        Objects.requireNonNull(getSupportActionBar()).hide();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                Intent intent=new Intent(MainActivity.this, BaseActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }

            @Override
            public void onCancel()
            {

            }

            @Override
            public void onError(FacebookException error)
            {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
