package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.munazamfyp.Adapters.ReminderAdapter;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.DataModels.date;
import com.example.munazamfyp.DataModels.ReminderItem;

import java.util.ArrayList;

import static com.example.munazamfyp.DataModels.Data.y;

public class ReminderView extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_view);


        ArrayList<ReminderModel> example_items= new ArrayList<>();


        if (y == null) {
            TextView error = findViewById(R.id.textView12);
            error.setText("The List is empty");
        }
        else
        {
            mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new ReminderAdapter(Data.x);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }


    }
    public void openreminder(View view)
    {
        Intent i = new Intent(this,EnterReminder.class);
        startActivity(i);
    }
}
