package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.munazamfyp.Connections.SetReminderConnection;
import com.example.munazamfyp.DataModels.ReminderData;
import com.example.munazamfyp.DataModels.ReminderItem;
import com.example.munazamfyp.DataModels.date;
import com.example.munazamfyp.DataModels.time;
import com.example.munazamfyp.Pickers.DatePickerFragment;
import com.example.munazamfyp.Pickers.TimePickerFragment;

public class EnterReminder extends AppCompatActivity {


    Spinner spin;
    Spinner spin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_reminder);
        spin = (Spinner) findViewById(R.id.spinner);
        String[] objects = { "Assignment", "Project", "Quiz", "Midterm"};
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects);
        spin.setAdapter(adapter);
        spin1 = (Spinner) findViewById(R.id.spinner2);
        String[] objects1 = { "Applied Physics", "Calculus and Analytical Geometry", "English Composition and Comprehension", "Introduction to Information and Communication Technologies", "Islamic and Religious Studies"};
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects1   );

        spin1.setAdapter(adapter1);

    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public void OpenNext(View view){

        ReminderData d = new ReminderData();
        d.setCourse(spin1.getSelectedItem().toString());
        d.setTopic(spin.getSelectedItem().toString());

        Intent I = new Intent(this, DataTimeScreen.class);
        startActivity(I);
    }

}
