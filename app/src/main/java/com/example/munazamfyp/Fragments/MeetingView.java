package com.example.munazamfyp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.Adapters.MeetingAdapter;
import com.example.munazamfyp.AddMeeting;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.DataModels.extendeditem;
import com.example.munazamfyp.EnterReminder;
import com.example.munazamfyp.R;

import java.util.ArrayList;
import java.util.List;

public class MeetingView extends Fragment {

    public static MeetingView newInstance()
    {
        return new MeetingView();
    }

    RecyclerView recyclerView;
    MeetingAdapter recyclerAdapter;

    List<extendeditem> Meetingitem;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public String th;
    private Button B;
    private PageViewModel pageViewModel;
    View root;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex("Meeting");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.meeting_activity, container, false);



        Meetingitem =new ArrayList<>();


        for(int i =0;i< Data.meetingModels.size();i++)
        {
            System.out.println("somethn");
            Meetingitem.add(new extendeditem(Data.meetingModels.get(i).getTopic(),Data.meetingModels.get(i).getTime(),Data.meetingModels.get(i).getDate(),Data.meetingModels.get(i).getDescription(),Data.meetingModels.get(i).getCapacity(),""+Data.meetingModels.get(i).getId()));
        }



        System.out.println("excuting meeting");

        B = root.findViewById(R.id.button17);

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openreminder();
            }
        });

        recyclerView = root.findViewById(R.id.recyclerView3);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerAdapter = new MeetingAdapter(Meetingitem,root.getContext());
        recyclerView.setAdapter(recyclerAdapter);


        return root;

    }
    public void openreminder()
    {
        Intent i = new Intent(root.getContext(), AddMeeting.class);
        startActivity(i);
    }


}
