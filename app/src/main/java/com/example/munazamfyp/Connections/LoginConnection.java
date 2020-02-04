package com.example.munazamfyp.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.time;
import com.example.munazamfyp.EmailVerification;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.SignUp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginConnection extends AsyncTask<Void, Void, Void> {
    ProgressDialog progressDialog;
    UserData UD;
    Context cx;

    LoginConnection() {

    }

    public LoginConnection(UserData ud, Context context) {
        cx = context;
        UD = ud;
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
        final Call<String>[] call = new Call[]{GDS.Get(UD.getID(), UD.getName(), UD.getPassword(),UD.getSemester())};

        try {
            x[0] = call[0].execute();
            System.out.println(x[0].body());
            Data.validid = x[0].body();
            System.out.println("somedata" + Data.validid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void v) {
        // execution of result of Long time consuming operation
        progressDialog.dismiss();

        if (Data.validid.equals("ok")) {
            Data.RID = UD.getID();
            Intent i = new Intent(cx, EmailVerification.class);
            cx.startActivity(i);
        }
        else
        {
              Toast.makeText(cx, "ID already Exist's", Toast.LENGTH_SHORT).show();
        }
    }
}
