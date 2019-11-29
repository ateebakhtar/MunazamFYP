package com.example.munazamfyp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.Adapters.ReminderAdapter;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.WorkloadViewModel;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.EnterReminder;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.R;

import java.util.ArrayList;

public class ReminderView extends Fragment
{
    ArrayList<WorkloadViewModel> list1 = new ArrayList<>();

    ReminderView()
    {

    }


    public static ReminderView newInstance() {
        return new ReminderView();
    }

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
        pageViewModel.setIndex("Reminder");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.activity_reminder_view, container, false);

        B = root.findViewById(R.id.imageButton2);

        ArrayList<ReminderModel> example_items= new ArrayList<>();
        mRecyclerView = root.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        mAdapter = new ReminderAdapter(Data.x);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openreminder();
            }
        });
        return root;

    }
    public void openreminder()
    {
        Intent i = new Intent(root.getContext(), EnterReminder.class);
        startActivity(i);
    }
}
