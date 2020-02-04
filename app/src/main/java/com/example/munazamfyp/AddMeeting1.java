package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddMeeting1 extends AppCompatActivity {
    Spinner spin;
    Spinner spin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting1);


    }

    public void OpenNext(View view){

        Intent I = new Intent(this, AddMeeting2.class);
        startActivity(I);

    }
}
