package com.example.munazamfyp.Connections;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.Interfaces.LoginInterface;
import com.example.munazamfyp.DataModels.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginConnection extends AsyncTask<Void, Void, Void>
{

    UserData UD;
    LoginConnection()
    {

    }
    public LoginConnection(UserData ud)
    {
        UD = ud;
    }
    //@Override
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
        final Call<String>[] call = new Call[]{GDS.Get(UD.getID(), UD.getName(), UD.getPassword())};

        try {
            x[0] = call[0].execute();
            Data.validid = x[0].body();
            System.out.println(x[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Looper.prepare();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(x[0].body().equals("ok"))
                {
                    call[0] = GDS.emailverify(UD.getID());

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
                    System.out.println(x[0].body()+" body");
                    System.out.println(x[0].message()+"message");

                }
            }
        },2000);
        return null;
    }

}
