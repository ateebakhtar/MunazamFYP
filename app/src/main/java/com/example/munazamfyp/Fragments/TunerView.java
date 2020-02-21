package com.example.munazamfyp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.Adapters.GPASuggestion;
import com.example.munazamfyp.Adapters.TunerAdapter;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.DataModels.TunerModel;
import com.example.munazamfyp.EnterReminder;
import com.example.munazamfyp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TunerView extends Fragment
{
    public static TunerView newInstance()
    {
        return new TunerView();
    }

    RecyclerView recyclerView;
    TunerAdapter movieAdapter;
    View root;
    static int counter = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.tuner_activity, container, false);

//        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1","!"));
//        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1","!"));
//        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1","!"));

        List<Integer> tuner = new ArrayList<Integer>();
        List<Boolean> expanded = new ArrayList<>();
        for(int i=1;i<9;i++)
        {
            tuner.add(i);
            expanded.add(true);
        }

        recyclerView = root.findViewById(R.id.recyclerView2);
        movieAdapter = new TunerAdapter(tuner,expanded,root.getContext(),0);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(movieAdapter);

        Button B = root.findViewById(R.id.button20);

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
        int counter = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Hello");
        GPASuggestion x = new GPASuggestion();
        double[] result = x.suggest(3.5,movieAdapter.getVal(),3);

        for(int i=0;i<8;i++)
        {
            if(result[i*7] != -1 || result[i*7+1] != -1 || result[i*7+2] != -1 || result[i*7+3] != -1 || result[i*7+4] != -1 || result[i*7+5] != -1 || result[i*7+6] != -1)
            {
                counter++;
            }
        }

        movieAdapter.setflag(counter);
        System.out.println();
        movieAdapter.setNewval(result);
        recyclerView.setAdapter(movieAdapter);
    }

}
