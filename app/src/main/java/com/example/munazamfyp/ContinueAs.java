package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.munazamfyp.Connections.AddMeetingConnections;
import com.example.munazamfyp.Connections.GetConnectionConnection;
import com.example.munazamfyp.Connections.GetMyMeetingConnection;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.GetSemester;
import com.example.munazamfyp.Connections.JoinedMeetingConnection;
import com.example.munazamfyp.Connections.MeetingListConnection;
import com.example.munazamfyp.Connections.OfflineConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.ReminderData;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.DataModels.Workload;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContinueAs extends AppCompatActivity {

    String nam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_as);

        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        nam = sharedpreferences.getString("name","x");
        Data.status = sharedpreferences.getString("id","x");
        new GetConnectionConnection(this).execute();

        if(Data.networkstatus.equals("notok"))
        {
            System.out.println("this is it the netweork");
        }
        else
        {
            System.out.println("connection rrdy"+Data.networkstatus);
        }

        TextView x = findViewById(R.id.contineas);
        x.setText(nam);
    }
    public void opencontinue(View view)
    {
        if(Data.networkstatus.equals("notok"))
        {
            System.out.println("this is it the netweork");
            new OfflineConnection(this).execute();

        }
        else
        {
            Data.mobj.setTime("123");
            Data.mobj.setTopic("123");
            Data.mobj.setCapacity("123");
            //Data.mobj.setCourse("123");
            Data.mobj.setName("asd");
            Data.mobj.setUniid("123");
            Data.mobj.setVenue("123");
            Data.mobj.setDescription("adsasdas");
            Data.mobj.setDate("13123");
            //new AddMeetingConnections(this).execute();
            new GetSemester(this).execute();
            new WorkloadConnection(this).execute();
            new GetReminderConnection(this).execute();
            new MeetingListConnection(this).execute();
            new JoinedMeetingConnection(this,nam).execute();
            new GetMyMeetingConnection(this,nam).execute();



            SharedPreferences sharedpreferences = getSharedPreferences("ofline", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();

            Gson x = new Gson();
            ArrayList<String> temp = new ArrayList<>();
            if(Data.y != null)
            {
                for(int i=0;i<Data.y.size();i++)
                {
                    String json = x.toJson(Data.y.get(i));
                    temp.add(json);
                }
            }
            Set<String> set = new HashSet<String>();
            set.addAll(temp);
            editor.putStringSet("workload", set);

            ArrayList<String> temp2 = new ArrayList<>();
            if(Data.x != null)
            {
                for(int i=0;i<Data.x.size();i++)
                {
                    String json = x.toJson(Data.x.get(i));
                    System.out.println("Added data to reminder");
                    temp2.add(json);
                }
            }
            Set<String> set1 = new HashSet<String>();
            set.addAll(temp2);
            editor.putStringSet("reminder", set1);



            editor.commit();
            editor.apply();

            System.out.println("connection rrdy"+Data.networkstatus);
        }


        Intent i = new Intent(this,mainmenu.class);
        startActivity(i);
    }
    public void openlogin(View view)
    {
        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("id", null);
        editor.putString("name", null);
        editor.apply();

        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
}
