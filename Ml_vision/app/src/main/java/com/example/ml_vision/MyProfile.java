package com.example.ml_vision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyProfile extends AppCompatActivity
{

    EditText st_email;
    SharedPreferences sharedPreferences;
    static final String mypreference="mypref";
    static final String phone="phoneKey";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity_my_profile);

        st_email=findViewById(R.id.phoneText);

        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(phone))
        {
            st_email.setText(sharedPreferences.getString(phone,""));
        }

        setDefaults(phone,st_email.getText().toString(),this);

    }

    public static void setDefaults(String key, String value, Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    public void save (View v)
    {
        String p = st_email.getText().toString();
        if (p.isEmpty())
        {
            Toast.makeText(this, "Field can't be Empty", Toast.LENGTH_SHORT).show();

        } else if (!Patterns.EMAIL_ADDRESS.matcher(p).matches())
        {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();

        }
        else
            {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(phone, p);
                editor.apply();
                Toast.makeText(this, "Email ID saved!", Toast.LENGTH_SHORT).show();
            }
    }

    public void clear(View v)
    {
        st_email.setText("");
        Toast.makeText(this, "Saved attributes cleared!", Toast.LENGTH_SHORT).show();
    }

    public String retrieve(View v)
    {
        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(phone))
        {
            st_email.setText(sharedPreferences.getString(phone,""));

            Toast.makeText(this, "Saved Email ID retrieved!", Toast.LENGTH_SHORT).show();
            return sharedPreferences.getString(phone,"");
        }

        Toast.makeText(this, "No email ID saved!", Toast.LENGTH_SHORT).show();
        return "xyz@gmail.com";

    }
}
