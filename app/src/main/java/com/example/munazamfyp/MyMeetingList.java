package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.munazamfyp.Adapters.MeetingAdapter;
import com.example.munazamfyp.Connections.AttendeesListConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.extendeditem;

import java.util.ArrayList;
import java.util.List;

public class MyMeetingList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_meeting_list);

        new AttendeesListConnection(this).execute();

        RecyclerView recyclerView;
        MeetingAdapter recyclerAdapter;

        List<extendeditem> Meetingitem;

        Meetingitem =new ArrayList<>();


        for(int i = 0; i< Data.mymeetings.size(); i++)
        {
            System.out.println("somethn");
            Meetingitem.add(new extendeditem(Data.mymeetings.get(i).getTopic(),Data.mymeetings.get(i).getTime(),Data.mymeetings.get(i).getDate(),Data.mymeetings.get(i).getDescription(),Data.mymeetings.get(i).getCapacity(),""+Data.mymeetings.get(i).getId()));
        }



        System.out.println("excuting meeting");


        recyclerView = findViewById(R.id.recyclerView5);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerAdapter = new MeetingAdapter(Meetingitem,this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
