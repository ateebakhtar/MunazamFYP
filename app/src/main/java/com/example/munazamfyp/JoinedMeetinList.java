package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.munazamfyp.Adapters.MeetingAdapter;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.extendeditem;

import java.util.ArrayList;
import java.util.List;

public class JoinedMeetinList extends AppCompatActivity {

    RecyclerView recyclerView;
    MeetingAdapter recyclerAdapter;

    List<extendeditem> Meetingitem;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joined_meetin_list);


        Meetingitem =new ArrayList<>();


        for(int i = 0; i< Data.joinedmeeting.size(); i++)
        {
            System.out.println("somethn");
            Meetingitem.add(new extendeditem(Data.joinedmeeting.get(i).getTopic(),Data.joinedmeeting.get(i).getTime(),Data.joinedmeeting.get(i).getDate(),Data.joinedmeeting.get(i).getDescription(),Data.joinedmeeting.get(i).getCapacity(),""+Data.joinedmeeting.get(i).getId()));
        }



        System.out.println("excuting meeting"+Data.joinedmeeting.get(0).getTopic());


        recyclerView = findViewById(R.id.recyclerView4);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerAdapter = new MeetingAdapter(Meetingitem,this);
        recyclerView.setAdapter(recyclerAdapter);

    }
}
