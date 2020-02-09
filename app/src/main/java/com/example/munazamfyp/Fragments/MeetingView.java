package com.example.munazamfyp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.Adapters.RecyclerAdapter;
import com.example.munazamfyp.Adapters.ReminderAdapter;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.DataModels.extendeditem;
import com.example.munazamfyp.R;

import java.util.ArrayList;
import java.util.List;

public class MeetingView extends Fragment {

    public static MeetingView newInstance()
    {
        return new MeetingView();
    }

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<extendeditem> moviesList;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public String th;
    private ImageButton B;
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



        moviesList=new ArrayList<>();


        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));
        moviesList.add( new extendeditem("FYP MEETING","2:30","12/3/19","a  nice nmeeting","10000"));

        System.out.println("excuting meeting");


        recyclerView = root.findViewById(R.id.recyclerView3);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerAdapter = new RecyclerAdapter(moviesList);
        recyclerView.setAdapter(recyclerAdapter);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(root.getContext(), DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        return root;

    }





}
