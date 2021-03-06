package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.MeetingModel;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.Interfaces.MeetingInterface;
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

public class GetMyMeetingConnection extends AsyncTask<Void,Void,Void>
{
    Context cx;
    public GetMyMeetingConnection(Context context,String nam)
    {
        cx = context;
        name = nam;
    }
    String name;
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



        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit m = new Retrofit.Builder()
                .baseUrl(Data.ip)
                //.baseUrl("http://192.168.100.6:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        MeetingInterface GDS = m.create(MeetingInterface.class);
        //JsonReader.setLenient(true);

        Call<ArrayList<MeetingModel>> call = GDS.getmymeeetinglist(name);
        //Call<String> call = GDS.Get(id);
        Response<ArrayList<MeetingModel>> x = null;
        try {
            x = call.execute();
            System.out.println(x);
            Data.mymeetings = x.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Data.x = x.body();

        return null;
    }
}
