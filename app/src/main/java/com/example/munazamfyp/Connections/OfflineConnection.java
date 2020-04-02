package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.DataModels.Workload;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OfflineConnection extends AsyncTask<Void, Void, Void>
{
    ProgressDialog progressDialog;

    Context cx;


    OfflineConnection() {

    }

    public OfflineConnection(Context context) {
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

        Gson x1 = new Gson();

        SharedPreferences sharedpreferences = cx.getSharedPreferences("ofline", Context.MODE_PRIVATE);
        final Set<String> x = sharedpreferences.getStringSet("workload",null);
        Iterator<String> it = x.iterator();
        Data.y = new ArrayList<>();
        while (it.hasNext())
        {
            Workload m = x1.fromJson(it.next().toString(), Workload.class);
            Data.y.add(m);
        }
        final Set<String> x2 = sharedpreferences.getStringSet("reminder",null);
        Iterator<String> it2 = x2.iterator();
        Data.x = new ArrayList<>();
        while (it2.hasNext())
        {

            ReminderModel m = x1.fromJson(it2.next().toString(), ReminderModel.class);
            System.out.println(m.getCoursename());
            Data.x.add(m);
        }

        return null;
    }


    @Override
    protected void onPostExecute(Void v) {

        progressDialog.dismiss();


    }
}
