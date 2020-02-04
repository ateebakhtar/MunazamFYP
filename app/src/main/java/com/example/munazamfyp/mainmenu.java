package com.example.munazamfyp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.munazamfyp.Adapters.TabsPagerAdapter;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
import com.example.munazamfyp.DataModels.Data;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class mainmenu extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        Handler handler =new Handler();

        dl = (DrawerLayout)findViewById(R.id.navigation);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:
                        Toast.makeText(mainmenu.this, "My Account",Toast.LENGTH_SHORT).show();
                        Intent i  = new Intent(mainmenu.this,UserInformationActivity.class);
                        startActivity(i);
                        break;
                    case R.id.settings:
                        Toast.makeText(mainmenu.this, "Settings",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(mainmenu.this, "Logging Out",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("id", null);
                        editor.putString("name", null);
                        editor.apply();
                        Intent i1  = new Intent(mainmenu.this,SplashScreen.class);
                        startActivity(i1);
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });

        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(tabsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tab_layout);
        tabs.setupWithViewPager(viewPager);
    }
}
