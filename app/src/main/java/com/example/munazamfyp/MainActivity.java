package com.example.munazamfyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;

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
    Spinner t1;
    Spinner t2;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;




    @Override
    protected void onStart() {

        t1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position == 1)
                {
                    String[] objects1 = {"a11","21","31"};
                    ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects1   );
                    t2.setAdapter(adapter2);

                }
                else if(position == 2)
                {
                    String[] objects1 = {"b12","22","32"};
                    ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects1   );
                    t2.setAdapter(adapter2);

                }
                else
                {
                    String[] objects1 = {"c13","23","33"};
                    ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects1   );
                    t2.setAdapter(adapter2);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        System.out.println(token);

        t1 = findViewById(R.id.spin1);
        t2 = findViewById(R.id.spin2);
        String[] objects1 = {"1","2","3"};
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects1   );
        t1.setAdapter(adapter1);

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
