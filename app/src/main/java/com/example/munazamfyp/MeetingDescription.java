package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.munazamfyp.Connections.AddMeetingConnections;
import com.example.munazamfyp.DataModels.Data;

public class MeetingDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_description);
    }

    public void OpenNext1(View view){

        EditText topic = findViewById(R.id.editText4);
        EditText description= findViewById(R.id.editText5);
        EditText capacity= findViewById(R.id.editText6);

        Data.mobj.setCapacity(capacity.getText().toString());
        Data.mobj.setDescription(description.getText().toString());
        Data.mobj.setTopic(topic.getText().toString());

        new AddMeetingConnections(this).execute();
        System.out.println("hellos after meeting");
        //new AddMeetingConnections(Data.mobj,this);

        Intent I = new Intent(this, mainmenu.class);
        startActivity(I);

    }
}
