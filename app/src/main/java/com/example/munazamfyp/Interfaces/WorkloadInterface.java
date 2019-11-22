package com.example.munazamfyp.Interfaces;

import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.DataModels.Workload;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WorkloadInterface
{

    @GET("/workload")
    public Call<ArrayList<Workload>> getdata();
}
