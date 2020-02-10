package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Bundle;
import android.os.Handler;

import com.example.munazamfyp.Connections.GetMyMeetingConnection;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.JoinedMeetingConnection;
import com.example.munazamfyp.Connections.MeetingListConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
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
                    new WorkloadConnection(SplashScreen.this).execute();
                    new GetReminderConnection(SplashScreen.this).execute();
                    new MeetingListConnection(SplashScreen.this).execute();
                    new JoinedMeetingConnection(SplashScreen.this).execute();
                    new GetMyMeetingConnection(SplashScreen.this).execute();
                    Intent intent=new Intent(SplashScreen.this,ContinueAs.class);
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
