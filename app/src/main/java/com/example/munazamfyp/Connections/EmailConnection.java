package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.EmailVerification;
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

public class EmailConnection extends AsyncTask<Void, Void, Void>
{
    ProgressDialog progressDialog;

    Context cx;

    EmailConnection() {

    }

    public EmailConnection( Context context) {
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
                .baseUrl("http://10.0.2.2:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        final LoginInterface GDS = m.create(LoginInterface.class);

        final Response<String>[] x = new Response[]{null};
        final Call<String>[] call = new Call[]{ GDS.emailverify(Data.RID)};



        x[0] = null;
        try {
            x[0] = call[0].execute();
            System.out.println(x[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = String.valueOf(x[0]);
        Data.code = code;
        Data.code = x[0].body();
        System.out.println(x[0].body() + " body");
        System.out.println(x[0].message() + "message");
        return null;
    }


    @Override
    protected void onPostExecute(Void v) {
        // execution of result of Long time consuming operation
        progressDialog.dismiss();

    }
}
