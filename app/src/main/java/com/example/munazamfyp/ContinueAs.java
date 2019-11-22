package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.munazamfyp.DataModels.UserData;

public class ContinueAs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_as);

        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        String nam = sharedpreferences.getString("name","x");

        TextView x = findViewById(R.id.contineas);
        x.setText(nam);
    }
    public void opencontinue(View view)
    {
        Intent i = new Intent(this,mainmenu.class);
        startActivity(i);
    }
    public void openlogin(View view)
    {
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
}
