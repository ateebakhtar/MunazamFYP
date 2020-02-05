package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.munazamfyp.Connections.AttendeesListConnection;

public class MyMeetingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_meeting_list);

        new AttendeesListConnection(this).execute();

        Intent i = new Intent(this,AttendeeList.class);
        startActivity(i);
    }
}
