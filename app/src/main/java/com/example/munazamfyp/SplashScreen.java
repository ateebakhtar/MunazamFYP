package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Bundle;
import android.os.Handler;

import com.example.munazamfyp.DataModels.UserData;

public class SplashScreen extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        final String nam = sharedpreferences.getString("name",null);
        System.out.println(nam);
        handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(nam != null)
                {
                    Intent intent=new Intent(SplashScreen.this,mainmenu.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(SplashScreen.this,Login.class);
                    startActivity(intent);
                }
                finish();
            }
        },4500);


    }
}
