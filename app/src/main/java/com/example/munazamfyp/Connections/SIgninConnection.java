package com.example.munazamfyp.Connections;

import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SIgninConnection extends AsyncTask<Void, Void, Void>
{
    SIgninConnection()
    {

    }
    public SIgninConnection(String name, String pass)
    {
        this.name = name;
        this.pass = pass;
    }
    String name;
    String pass;

    protected Void doInBackground(Void... voids)
    {
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

        LoginInterface GDS = m.create(LoginInterface.class);
        Call<String> call = GDS.Getlogin(name,pass);
        Response<String> x = null;

        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String code = String.valueOf(x);
        System.out.println(x.body()+" body");
        System.out.println(x.message()+"message");
        if(!x.body().equals("notok"))
        {
            Data.status = x.body();
            return null;
        }
        else
        {
            Data.status = "notok";
            return null;
        }
    }
}
