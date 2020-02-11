package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.munazamfyp.Connections.AddMeetingConnections;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.Pickers.DatePickerFragment;
import com.example.munazamfyp.Pickers.TimePickerFragment;

public class AddMeeting2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting2);
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void OpenNext1(View view){

        EditText topic = findViewById(R.id.editText4);
        EditText description= findViewById(R.id.editText5);
        EditText capacity= findViewById(R.id.editText6);

        Data.mobj.setCapacity(capacity.getText().toString());
        Data.mobj.setDescription(description.getText().toString());
        Data.mobj.setTopic(topic.getText().toString());

        new AddMeetingConnections(Data.mobj,this);

        Intent I = new Intent(this, mainmenu.class);
        startActivity(I);

    }
}
