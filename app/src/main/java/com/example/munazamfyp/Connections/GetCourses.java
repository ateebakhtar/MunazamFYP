package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.munazamfyp.DataModels.CourseModel;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.example.munazamfyp.Interfaces.ReminderInterface;
import com.example.munazamfyp.SplashScreen;
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

public class GetCourses extends AsyncTask<Void, Void, Void>
{
    ProgressDialog progressDialog;
    UserData UD;
    Context cx;

    String name;
    String sec;
    GetCourses() {

    }

    public GetCourses(Context context, String name, String section) {
        cx = context;
        this.name = name;
        sec = section;
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


        final ReminderInterface GDS = m.create(ReminderInterface.class);

        final Response<ArrayList<CourseModel>>[] x = new Response[]{null};
        final Call<ArrayList<CourseModel>>[] call = new Call[]{GDS.getcourses("1")};

        try {
            x[0] = call[0].execute();
            System.out.println(x[0].body());
            //Data.semester = x[0].body();
            //String m123  = x[0].body();
            Data.courses = x[0].body();
            //System.out.println("somedata" + m123);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void v) {
        // execution of result of Long time consuming operation
        progressDialog.dismiss();


    }
}
