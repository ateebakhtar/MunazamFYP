package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.Interfaces.GetDataService;
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

public class UpdateWorkloadConnection extends AsyncTask<Void, Void, Void>
{
    String id;
    Context cx;

    public UpdateWorkloadConnection(String id,Context context)
    {
        cx = context;
        this.id = id;
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
                .baseUrl(Data.ip)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WorkloadInterface GDS = m.create(WorkloadInterface.class);

        Call<String> call = GDS.data(id);
        Response<String> x = null;
        try
        {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        return null;
    }
}
