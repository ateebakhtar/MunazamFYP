package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void axd(View view) throws IOException
    {
          new Connection().execute();
//        Retrofit m = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000/api/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//        GetDataService GDS = m.create(GetDataService.class);
//
//        Call<String> call = GDS.Get();
//        Response<String> x = null;
//        try {
//            x = call.execute();
//            System.out.println(x);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
