package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.munazamfyp.Connections.GetMyMeetingConnection;
import com.example.munazamfyp.Connections.GetReminderConnection;
import com.example.munazamfyp.Connections.GetSemester;
import com.example.munazamfyp.Connections.JoinedMeetingConnection;
import com.example.munazamfyp.Connections.MeetingListConnection;
import com.example.munazamfyp.Connections.SIgninConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.UserData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Login extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void forgotpassword(View view)
    {
        Intent i = new Intent(this,ForgotPassword.class);
        startActivity(i);
    }

    public void loginAction(View view)
    {
        final EditText name = findViewById(R.id.editText6);
        final EditText pass = findViewById(R.id.editText7);


        if(name.getText().toString() == null)
        {
            name.setError("Enter ID");
            name.requestFocus();
        }
        else if(name.getText().toString().length() != 7 )
        {
            name.setError("Enter Valid ID");
            name.requestFocus();
        }
        else if(name.getText().toString() != null && pass.getText().toString() != null)
        {
            new SIgninConnection(name.getText().toString(),pass.getText().toString(),this).execute();

            handler =new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    if(!Data.status.equals("notok"))
                    {
                        Toast.makeText(Login.this, "Welcome", Toast.LENGTH_SHORT).show();
                        UserData.name = name.getText().toString();
                        UserData.password = pass.getText().toString();

                        System.out.println("id == "+Data.status);
                        System.out.println(("Vlaid "+Data.validid)+" "+Data.status);
                        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("id",Data.status);
                        editor.putString("name", name.getText().toString());
                        editor.apply();


                        new GetSemester(Login.this).execute();
                        new WorkloadConnection(Login.this).execute();
                        new GetReminderConnection(Login.this).execute();
                        new MeetingListConnection(Login.this).execute();
                        new JoinedMeetingConnection(Login.this,name.getText().toString()).execute();
                        new GetMyMeetingConnection(Login.this,name.getText().toString()).execute();



                        SharedPreferences sharedpreferencesa = getSharedPreferences("ofline", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editora = sharedpreferencesa.edit();

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
                        editora.putStringSet("workload", set);

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
                        editora.putStringSet("reminder", set1);



                        editora.commit();
                        editora.apply();

                        System.out.println("connection rrdy"+Data.networkstatus);

                        Intent i = new Intent(Login.this,mainmenu.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Login.this,"Incorrecnt ID or Password",Toast.LENGTH_SHORT).show();
                        name.setError("Incorrecnt ID or Password");
                        pass.setError("Incorrecnt ID or Password");
                    }


                }
            },1500);



        }

    }
    public void forogtpass(View view)
    {
        Toast.makeText(this, "Forgot Password" +
                "", Toast.LENGTH_SHORT).show();
    }
    public void opencreateaccount(View view)
    {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }
}
