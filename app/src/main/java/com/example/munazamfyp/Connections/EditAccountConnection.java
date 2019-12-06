package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.EmailVerification;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.example.munazamfyp.Interfaces.WorkloadInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditAccountConnection extends AsyncTask<Void, Void, Void>
{
    public EditAccountConnection(String id, String name, String pass,Context context) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.cx = context;
    }
    Context cx;
    String id;
    String name;
    String pass;
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
                .baseUrl("http://10.0.2.2:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        LoginInterface GDS = m.create(LoginInterface.class);
        //JsonReader.setLenient(true);
        Call<String> call = GDS.getedit(name,pass,id);
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
