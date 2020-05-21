package com.example.munazamfyp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.munazamfyp.Connections.EditAccountConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.UserData;

public class UserInformationActivity extends AppCompatActivity
{

    private Button B;
    private Button edit;

    EditText name;
    EditText ID;
    EditText password;

    ToggleButton notifiaction;
    ToggleButton hints;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        edit = findViewById(R.id.button12);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openedit();
            }
        });

        ID = findViewById(R.id.uniid);
        notifiaction = findViewById(R.id.toggleButton2);
        hints = findViewById(R.id.toggleButton);

        notifiaction.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(UserInformationActivity.this, "Notifications Turned on", Toast.LENGTH_SHORT).show();
                    Data.noficationstatus = 1;
                } else {
                    Toast.makeText(UserInformationActivity.this, "Notifications Turned Off", Toast.LENGTH_SHORT).show();
                    Data.noficationstatus = 0;
                }
            }
        });

        hints.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(UserInformationActivity.this, "Hints Turned on", Toast.LENGTH_SHORT).show();
                    Data.showdialog = 1;
                } else {
                    Toast.makeText(UserInformationActivity.this, "Hints Turned Off", Toast.LENGTH_SHORT).show();
                    Data.showdialog = 1;
                }
            }
        });

        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        String nam = sharedpreferences.getString("name","x");

        ID.setText(nam);

    }

    public void openselectcourses(View view)
    {
        Intent i = new Intent(this,SelectCourses.class);
        startActivity(i);
    }

    public void openedit()
    {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.editaccountpromt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder.setTitle("Edit Account");
        final EditText nam = promptsView.findViewById(R.id.editText9);
        final EditText pass = promptsView.findViewById(R.id.editText11);
        if(nam.getText().toString().length() < 3 || nam.getText().toString() == null)
        {
            nam.setError("Please Enter a Valid Name of size 3 or more");
            nam.requestFocus();
        }
        else if(pass.getText().toString().length() < 8 || pass.getText().toString() == null)
        {
            pass.setError("Please Enter a Valid Password of size 8 or more");
            pass.requestFocus();
        }
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Update",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id)
                            {
                                String name = nam.getText().toString();

                                String pass1 = pass.getText().toString();
                                if(name.length() >= 3 && pass1.length() >=8)
                                {
                                    System.out.println("values ---- "+ Data.status);
                                    new EditAccountConnection(Data.status,name,pass1,UserInformationActivity.this).execute();
                                    Intent i = new Intent(UserInformationActivity.this,Login.class);
                                    startActivity(i);
                                }
                                else
                                {
                                    Toast.makeText(UserInformationActivity.this, "Incorrect Length of Password or Username", Toast.LENGTH_SHORT).show();
                                }


                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();



    }

}
