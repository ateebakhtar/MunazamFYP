package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.munazamfyp.Adapters.WorkloadDetailAdapter;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.WorkloadDetailModel;

import java.util.ArrayList;
import java.util.Calendar;

public class DetailedWorkload extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WorkloadDetailAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    TextView dayy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_workload);

        ArrayList<WorkloadDetailModel> exampleList2 = new ArrayList<WorkloadDetailModel>();

        dayy = findViewById(R.id.textView14);

        mRecyclerView = findViewById(R.id.recyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(DetailedWorkload.this);

        mAdapter = new WorkloadDetailAdapter(exampleList2);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Bundle p = new Bundle();
        p = getIntent().getExtras();

        int day = p.getInt("pos");
        int m = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        m = m + day;
        if(m>7)
        {
            m = m - 7;
        }
        for(int i=0;i< Data.y.size();i++)
        {
            if(Data.y.get(i).getDay().equals(""+day))
            {
                String ty = null;
                if(Data.y.get(i).getType().equals("Assignment"))
                {
                    ty = "a1";
                }
                else if(Data.y.get(i).getType().equals("Project"))
                {
                    ty = "p1";
                }
                else if(Data.y.get(i).getType().equals("Quiz"))
                {
                    ty = "q1";
                }
                else if(Data.y.get(i).getType().equals("Midterm"))
                {
                    ty = "e1";
                }
                System.out.println(Data.y.get(i).getCourse());
                exampleList2.add(new WorkloadDetailModel(ty, Data.y.get(i).getCourse(), Data.y.get(i).getType(), "Day Left: "+Data.y.get(i).getDayleft(),Data.y.get(i).getId()));

                //exampleList2.add(new WorkloadDetailModel("a", "20/10/2020", Data.y.get(i).getType(), Data.y.get(i).getCourse()));
            }
        }

        //exampleList2.add(new WorkloadDetailModel("a", "20/10/2020", "Assignmnet", "Human computer interaction"));

        switch (m) {
            case Calendar.SUNDAY:
                dayy.setText("Sunday");
                break;
            case Calendar.WEDNESDAY:
                dayy.setText("Wednesday");
                break;
            case Calendar.THURSDAY:
                dayy.setText("Thursday");
                break;
            case Calendar.FRIDAY:
                dayy.setText("Friday");
                break;
            case Calendar.MONDAY:
                dayy.setText("Monday");
                break;
            case Calendar.TUESDAY:
                dayy.setText("Tuesday");
                break;
            case Calendar.SATURDAY:
                dayy.setText("Saturday");
                break;
        }

        mAdapter = new WorkloadDetailAdapter(exampleList2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
