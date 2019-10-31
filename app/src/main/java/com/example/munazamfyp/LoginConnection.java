package com.example.munazamfyp;

import android.os.AsyncTask;
import android.util.JsonReader;

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
    LoginConnection(UserData ud)
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
        LoginInterface GDS = m.create(LoginInterface.class);
        //JsonReader.setLenient(true);
        //Call<String> call = GDS.Get(UD.getName(),UD.getID(),UD.getPassword());
        //Call<String> call = GDS.Get(id);
        Call<String> call = GDS.emailverify(UD.getID());
        Response<String> x = null;
        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String code = String.valueOf(x);
//        EmailVerification EV = new EmailVerification();
  //      EV.getCode(code);
        Data.code = code;
        Data.code = x.body();
        System.out.println(x.body()+" body");
        System.out.println(x.message()+"message");

        call = GDS.Get(UD.getName(),UD.getID(),UD.getPassword());
        x = null;
        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    protected  void backx()
    {
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
        //Call<String> call = GDS.Get(UD.getName(),UD.getID(),UD.getPassword());
        //Call<String> call = GDS.Get(id);
        Call<String> call = GDS.emailverify(UD.getID());
        Response<String> x = null;
        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = String.valueOf(x);
//        EmailVerification EV = new EmailVerification();
        //      EV.getCode(code);
        Data.code = code;
        Data.code = x.body();
        System.out.println(x.body()+" body");
        System.out.println(x.message()+"message");

    }

    protected void onPostExecute()
    {
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
        Call<String> call = GDS.Get(UD.getName(),UD.getID(),UD.getPassword());
        //Call<String> call = GDS.Get(id);
        //Call<String> call = GDS.emailverify(UD.getID());
        Response<String> x = null;
        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(x.body()+" body");
        System.out.println(x.message()+"message");
        //return null;


    }


    //@Override
    protected Void Post(Void... voids) {



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
        //Call<String> call = GDS.Get(UD.getName(),UD.getID(),UD.getPassword());
        //Call<String> call = GDS.Get(id);
        Call<String> call = GDS.emailverify(UD.getID());
        Response<String> x = null;
        try {
            x = call.execute();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = String.valueOf(x);
//        EmailVerification EV = new EmailVerification();
        //      EV.getCode(code);
        Data.code = code;
        Data.code = x.body();
        System.out.println(x.body()+" body");
        System.out.println(x.message()+"message");
        return null;
    }
}
