package com.example.munazamfyp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.munazamfyp.Adapters.TabsPagerAdapter;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.JoinedMeetingConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
import com.example.munazamfyp.DataModels.Data;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class mainmenu extends AppCompatActivity {
    private DrawerLayout dl;
    //private  Button button;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        Handler handler =new Handler();

        SharedPreferences sharedpreferences = getSharedPreferences("DialogBox", Context.MODE_PRIVATE);
        String stat = sharedpreferences.getString("Status","x");
        if(!stat.equals("0"))
        {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom);
            dialog.setTitle("Title...");

            // set the custom dialog components - text, image and button

            ImageView image = (ImageView) dialog.findViewById(R.id.imageView);
            ImageView image1 = (ImageView) dialog.findViewById(R.id.imageView2);
            ImageView image2 = (ImageView) dialog.findViewById(R.id.imageView3);
            ImageView image3 = (ImageView) dialog.findViewById(R.id.imageView4);

            checkBox = dialog.findViewById(R.id.checkBox);



            image.setImageResource(R.drawable.a1);
            image1.setImageResource(R.drawable.q1);
            image2.setImageResource(R.drawable.e1);
            image3.setImageResource(R.drawable.p1);

            Button dialogButton = (Button) dialog.findViewById(R.id.button);
            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(checkBox.isChecked())
                    {
                        System.out.println("is checked");
                        SharedPreferences sharedpreferences = getSharedPreferences("DialogBox", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("Status","0");
                        editor.apply();
                        Data.showdialog = 0;
                    }

                    dialog.dismiss();
                }
            });

            dialog.show();
        }


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
                    case R.id.joined:
                        Toast.makeText(mainmenu.this, "Joined Meetins", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
                        String nam = sharedpreferences.getString("name","x");
                        new JoinedMeetingConnection(mainmenu.this,nam).execute();
                        Intent i4 = new Intent(mainmenu.this,JoinedMeetinList.class);
                        startActivity(i4);
                        break;
                    case R.id.mymeeting:
                        Toast.makeText(mainmenu.this, "My hosted meeteings", Toast.LENGTH_SHORT).show();
                        Intent i5 = new Intent(mainmenu.this,MyMeetingList.class);
                        startActivity(i5);
                        break;
                    case R.id.settings:
                        Toast.makeText(mainmenu.this, "Settings",Toast.LENGTH_SHORT).show();
                        Intent i  = new Intent(mainmenu.this,UserInformationActivity.class);
                        startActivity(i);
                        break;
                    case R.id.logout:
                        Toast.makeText(mainmenu.this, "Logging Out",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences1 = getSharedPreferences("Login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();
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
