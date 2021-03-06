package com.example.munazamfyp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.munazamfyp.Adapters.MeetingAdapter;
import com.example.munazamfyp.Adapters.ReminderAdapter;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.MeetingListConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.WorkloadViewModel;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.EnterReminder;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.example.munazamfyp.DataModels.Data.y;

public class ReminderView extends Fragment
{
    ArrayList<WorkloadViewModel> list1 = new ArrayList<>();

    public ReminderView()
    {

    }


    public static ReminderView newInstance() {
        return new ReminderView();
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public String th;
    private FloatingActionButton B;
    private PageViewModel pageViewModel;
    View root;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex("Reminder");
        newInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.activity_reminder_view, container, false);

        final SwipeRefreshLayout pullToRefresh = root.findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new GetReminderConnection(root.getContext()).execute();
                mAdapter = new ReminderAdapter(Data.x);
                mRecyclerView.setAdapter(mAdapter);
                // your code
                pullToRefresh.setRefreshing(false);
            }
        });

        B = root.findViewById(R.id.imageButton2);

        if (Data.x == null) {
            TextView error = root.findViewById(R.id.textView12);
            error.setText("The List is empty");
            return null;
        }

        ArrayList<ReminderModel> example_items= new ArrayList<>();
        mRecyclerView = root.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        mAdapter = new ReminderAdapter(Data.x);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(mLayoutManager);


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
