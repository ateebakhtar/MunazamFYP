package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.MeetingModel;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.example.munazamfyp.Interfaces.MeetingInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class AddMeetingConnections extends AsyncTask<Void, Void, Void>
{
    public AddMeetingConnections(MeetingModel mm, Context context) {
        this.mm = mm;
        this.cx = context;
    }
    MeetingModel mm;
    Context cx;

    ProgressDialog progressDialog;

    @Override
    protected void onPostExecute(Void v) {
        // execution of result of Long time consuming operation
        progressDialog.dismiss();

    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(cx, "ProgressDialog", "Wait for "+ " seconds");
    }

    @Override
    protected Void doInBackground(Void... voids) {

        System.out.println("Hello from meeting connection");

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit m = new Retrofit.Builder()
                .baseUrl(Data.ip)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        MeetingInterface GDS = m.create(MeetingInterface.class);

        //JsonReader.setLenient(true);
        //@GET("/meeting/{course}/{name}/{id}/{venue}/{time}/{date}/{capacity}/{topic}/{description}")
        //hello
        Call<String> call = GDS.addmeeting(mm.getCourse(),mm.getName(),mm.getUniid(),mm.getVenue(),mm.getTime(),mm.getDate(),mm.getCapacity(),mm.getTopic(),mm.getDescription());
        //Call<String> call = GDS.Get(id);
        Response<String> x = null;
        try
        {
            System.out.println("hellososos");
            x = call.execute();
            System.out.println(x);
        }
        catch (IOException e)
        {
            System.out.println("didtn work");
            e.printStackTrace();
        }


        return null;
    }
}
