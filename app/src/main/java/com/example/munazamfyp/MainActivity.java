package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;

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
        new GetReminderConnection().execute();
        new WorkloadConnection().execute();
        Intent i = new Intent(this,SplashScreen.class);
        startActivity(i);
    }
    public void openX(View view)
    {
        Intent i = new Intent(this,EnterReminder.class);
        startActivity(i);
    }
    public void Openy(View view)
    {
        Intent i = new Intent(this,ReminderView.class);
        startActivity(i);
    }
    public void openw(View view)
    {
        Intent i = new Intent(this,WorkloadView.class);
        startActivity(i);
    }
    public void openmain(View view)
    {
        Intent i = new Intent(this,mainmenu.class);
        startActivity(i);
    }
    public void axd(View view) throws IOException
    {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }

}
