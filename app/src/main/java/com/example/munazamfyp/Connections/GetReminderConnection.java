package com.example.munazamfyp.Connections;

import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.Interfaces.GetDataService;
import com.example.munazamfyp.Interfaces.ReminderInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetReminderConnection extends AsyncTask<Void, Void, Void>
{
    @Override
    protected Void doInBackground(Void... voids) {



        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit m = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ReminderInterface GDS = m.create(ReminderInterface.class);
        //JsonReader.setLenient(true);
        Call<ArrayList<ReminderModel>> call = GDS.getdata("a");
        //Call<String> call = GDS.Get(id);
        Response<ArrayList<ReminderModel>> x = null;
        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Data.x = x.body();

        return null;
    }
}
