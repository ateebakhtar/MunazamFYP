package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.CourseModel;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.example.munazamfyp.Interfaces.ReminderInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetConnectionConnection extends AsyncTask<Void, Void, Void>
{
    ProgressDialog progressDialog;
    UserData UD;
    Context cx;

    String name;
    String sec;
    GetConnectionConnection() {

    }

    public GetConnectionConnection(Context context) {
        cx = context;

    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(cx,
                "ProgressDialog",
                "Wait for "+ " seconds");
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
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        final LoginInterface GDS = m.create(LoginInterface.class);

        final Response<String>[] x = new Response[]{null};
        final Call<String>[] call = new Call[]{GDS.getconnection()};

        try {
            x[0] = call[0].execute();
            System.out.println(x[0].body());

            Data.networkstatus = x[0].body();

        }
        catch (IOException e) {
            Data.networkstatus = "notok";
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Void v) {

        progressDialog.dismiss();


    }
}
