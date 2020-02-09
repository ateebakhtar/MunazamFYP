package com.example.munazamfyp.Fragments;

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

import com.example.munazamfyp.Adapters.TunerAdapter;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.DataModels.TunerModel;
import com.example.munazamfyp.R;

import java.util.ArrayList;
import java.util.List;

public class TunerView extends Fragment
{
    public static TunerView newInstance()
    {
        return new TunerView();
    }

    RecyclerView recyclerView;
    List<TunerModel> tuner = new ArrayList<TunerModel>();
    View root;


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

        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1"));
        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1"));
        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1"));

        recyclerView = root.findViewById(R.id.recyclerView2);
        TunerAdapter movieAdapter = new TunerAdapter(tuner);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(movieAdapter);



        return root;

    }
}
