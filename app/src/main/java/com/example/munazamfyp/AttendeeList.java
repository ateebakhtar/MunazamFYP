package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.munazamfyp.Connections.AttendeesListConnection;
import com.example.munazamfyp.DataModels.Data;

import java.util.ArrayList;

public class AttendeeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_list);

       // new AttendeesListConnection(this).execute();

        final ListView listview = (ListView) findViewById(R.id.listview);
        final ArrayList<String> list = new ArrayList<String>();
        if(Data.m == null)
        {
            Toast.makeText(this, "List empty", Toast.LENGTH_SHORT).show();
            return;
        }
        for(int i=0;i< Data.m.size();i++)
        {
            list.add(Data.m.get(i).getUniid());
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);


    }
}
