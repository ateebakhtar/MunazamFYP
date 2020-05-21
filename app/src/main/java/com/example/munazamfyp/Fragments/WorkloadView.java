package com.example.munazamfyp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.munazamfyp.Adapters.ReminderAdapter;
import com.example.munazamfyp.Adapters.WorkloadViewAdapter;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.WorkloadViewModel;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.DataModels.Workload;
import com.example.munazamfyp.R;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.munazamfyp.DataModels.Data.y;

public class WorkloadView extends Fragment
{
    ArrayList<WorkloadViewModel> list1 = new ArrayList<>();

    WorkloadView()
    {

    }


    public static WorkloadView newInstance() {
        return new WorkloadView();
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public String th;
    private PageViewModel pageViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex("Workload");


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.activity_workload_view, container, false);

        //new WorkloadConnection(root.getContext()).execute();

        final SwipeRefreshLayout pullToRefresh = root.findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new WorkloadConnection(root.getContext()).execute();
                mAdapter=new WorkloadViewAdapter(list1,root.getContext());
                mRecyclerView.setAdapter(mAdapter);
                // your code
                pullToRefresh.setRefreshing(false);
            }
        });

        final ArrayList<WorkloadViewModel> exampleList = new ArrayList<>();

        if (Data.y == null) {
            TextView error = root.findViewById(R.id.textView9);
            error.setText("The List is empty");
            return null;
        }

        mRecyclerView=root.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(root.getContext());
        mAdapter=new WorkloadViewAdapter(exampleList,root.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        int[] task = new int[4];
        task = new int[]{0, 0, 0, 0};
        Workload wl = new Workload();
        //wl = Data.y.get(5);
        int m = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        //System.out.println(wl.getDay());
        for(int i=0;i<7;i++)
        {
            task = new int[]{0, 0, 0, 0};

            for(int j=0;j< y.size();j++)
            {
                if(y.get(j).getType().equals("Assignment") && y.get(j).getDay().equals(""+i))
                {
                    task[0] = 1;
                }
                else if(y.get(j).getType().equals("Project")&& y.get(j).getDay().equals(""+i))
                {
                    task[1] = 1;
                }
                else if(y.get(j).getType().equals("Quiz")&& y.get(j).getDay().equals(""+i))
                {
                    task[2] = 1;
                }
                else if(y.get(j).getType().equals("Midterm")&& y.get(j).getDay().equals(""+i))
                {
                    task[3] = 1;
                }
            }
            switch (m) {
                case Calendar.SUNDAY:
                    list1.add(new WorkloadViewModel("a"+task[0],"q"+task[2],"p"+task[1],"e"+task[3],"Sunday"));
                    // Current day is Sunday
                    break;
                case Calendar.WEDNESDAY:
                    list1.add(new WorkloadViewModel("a"+task[0],"q"+task[2],"p"+task[1],"e"+task[3],"Wednesday"));
                    // Current day is Monday
                    break;
                case Calendar.THURSDAY:
                    list1.add(new WorkloadViewModel("a"+task[0],"q"+task[2],"p"+task[1],"e"+task[3],"Thursday"));
                    // Current day is Monday
                    break;
                case Calendar.FRIDAY:
                    list1.add(new WorkloadViewModel("a"+task[0],"q"+task[2],"p"+task[1],"e"+task[3],"Friday"));
                    // Current day is Monday
                    break;
                case Calendar.MONDAY:
                    list1.add(new WorkloadViewModel("a"+task[0],"q"+task[2],"p"+task[1],"e"+task[3],"Monday"));
                    // Current day is Monday
                    break;
                case Calendar.TUESDAY:
                    list1.add(new WorkloadViewModel("a"+task[0],"q"+task[2],"p"+task[1],"e"+task[3],"Tuesday"));
                    // etc.
                    break;
                case Calendar.SATURDAY:
                    list1.add(new WorkloadViewModel("a"+task[0],"q"+task[2],"p"+task[1],"e"+task[3],"Saturday"));
                    // Current day is Monday
                    break;
            }
            m++;
            System.out.println("value"+m);
            if(m == 8)
            {
                m = 1;
            }
            //list1.add(new WorkloadViewModel("a1","q1","p","e1","7/10/20"));
        }


        mAdapter=new WorkloadViewAdapter(list1,root.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return root;
    }
}
