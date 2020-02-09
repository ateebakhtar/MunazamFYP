package com.example.munazamfyp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.R;

public class GPAView extends Fragment
{
    public static GPAView newInstance()
    {
        return new GPAView();
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public String th;
    private Button opent;
    private  Button openp;
    private PageViewModel pageViewModel;
    View root;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex("GPA");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.activity_gpa, container, false);
        opent = root.findViewById(R.id.button14);
        openp = root.findViewById(R.id.button15);

        opent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentuner();
            }
        });
        openp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprdictor();
            }
        });

        FragmentManager fm = getFragmentManager();
        Fragment x = TunerView.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, x);
        ft.commit();


        return root;

    }
    public void opentuner()
    {
        System.out.println("tuner_template to be opened");
        FragmentManager fm = getFragmentManager();
        Fragment x = TunerView.newInstance();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, x);
        ft.commit();
    }
    public void openprdictor()
    {
        System.out.println("predictor to be opened");
        FragmentManager fm = getFragmentManager();
        Fragment x = PredictorView.newInstance();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, x);
        ft.commit();
    }
}
