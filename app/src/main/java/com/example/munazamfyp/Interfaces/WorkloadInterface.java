package com.example.munazamfyp.Interfaces;

import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.DataModels.Workload;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WorkloadInterface
{

    @GET("/workload/{id}")
    public Call<ArrayList<Workload>> getdata(@Path("id") String id);

    @GET("/editworkload/{id}")
    public Call<String> data(@Path("id") String id);

}
