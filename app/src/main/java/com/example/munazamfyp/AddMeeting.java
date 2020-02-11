package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.munazamfyp.DataModels.Data;

public class AddMeeting extends AppCompatActivity {

    Spinner spin;
    Spinner spin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        spin = (Spinner) findViewById(R.id.spinner);


        String[] objects = {"Assignment", "Project", "Quiz", "Midterm"};


        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1, objects);



        spin.setAdapter(adapter);
        spin1 = (Spinner) findViewById(R.id.spinner2);

// Array of Months acting as a data pump
        String[] objects1 = {"Applied Physics", "Calculus and Analytical Geometry", "English Composition and Comprehension", "Introduction to Information and Communication Technologies", "Islamic and Religious Studies"};

// Declaring an Adapter and initializing it to the data pump
        ArrayAdapter adapter1 = new ArrayAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1, objects1);

// Setting Adapter to the Spinner
        spin1.setAdapter(adapter1);



    }

    public void OpenNext(View view){

        Data.mobj.setCourse(spin1.getSelectedItem().toString());
        Intent I = new Intent(this, AddMeeting1.class);
        startActivity(I);

    }
}
