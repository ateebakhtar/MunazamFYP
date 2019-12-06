package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.Workload;
import com.example.munazamfyp.Interfaces.GetDataService;
import com.example.munazamfyp.Interfaces.WorkloadInterface;
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

public class WorkloadConnection extends AsyncTask<Void, Void, Void>
{
    String id;
    Context cx;
    public WorkloadConnection(Context context)
    {
        cx = context;
    }
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
        WorkloadInterface GDS = m.create(WorkloadInterface.class);
        //JsonReader.setLenient(true);
        Call<ArrayList<Workload>> call = GDS.getdata(Data.status);
        //Call<String> call = GDS.Get(id);
        Response<ArrayList<Workload>> x = null;
        try {
            x = call.execute();
            Data.y = new ArrayList<Workload>();
            Data.y = x.body();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
