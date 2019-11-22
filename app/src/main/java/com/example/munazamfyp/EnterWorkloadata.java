package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EnterWorkloadata extends AppCompatActivity {

    Spinner s;
    Spinner s1;
    String[] objects = { "1", "2", "3", "4","5", "6", "7"};
    String[] objects1 = { "1", "2", "3", "4","5", "6", "7","8", "9", "10","11", "12"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_workload);


        s = findViewById(R.id.spinner3);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects);
        s.setAdapter(adapter);

        s = findViewById(R.id.spinner4);
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects1);
        s.setAdapter(adapter1);

    }
    public void openclock(View view)
    {

    }
}
