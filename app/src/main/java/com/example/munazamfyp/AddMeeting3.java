package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddMeeting3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting2);
    }
    void openmain(View view)
    {
        Intent i = new Intent(this,mainmenu.class);
        startActivity(i);
    }
}
