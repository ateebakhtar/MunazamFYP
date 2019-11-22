package com.example.munazamfyp.Connections;

import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.ReminderItem;
import com.example.munazamfyp.Interfaces.GetDataService;
import com.example.munazamfyp.Interfaces.ReminderInterface;
import com.example.munazamfyp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SetReminderConnection extends AsyncTask<Void, Void, Void>
{
    String prio = "5";
    public SetReminderConnection()
    {

    }
    ReminderItem RI;

    public SetReminderConnection(ReminderItem RI,String prio)
    {
        this.RI = RI;
        this.prio = prio;
    }

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
        Call<String> call = GDS.putdata("1",RI.typw,RI.date,RI.time,RI.coursename,prio);
        //Call<String> call = GDS.Get(id);
        Response<String> x = null;
        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
