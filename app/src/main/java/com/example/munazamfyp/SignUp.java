package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.munazamfyp.Connections.LoginConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.UserData;

public class SignUp extends AppCompatActivity {


    EditText name;
    EditText pass;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void performLogin(View view)
    {
        name = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText3);
        id = findViewById(R.id.editText4);

        if(name.getText().toString().length() > 3 && pass.getText().toString().length() >8 && id.getText().toString().length() > 7)
        {
            UserData toBeSent = new UserData();
            toBeSent.setName(name.getText().toString());
            toBeSent.setID(id.getText().toString());
            toBeSent.setPassword(pass.getText().toString());

            new LoginConnection(toBeSent).execute();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(Data.validid == "ok")
                    {
                        Intent i = new Intent(SignUp.this,EmailVerification.class);
                        startActivity(i);        }
                    else
                    {
                        Toast.makeText(SignUp.this, "ID already Exist's", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }
            },3000);


        }
        else
        {
            Toast.makeText(this, "Incorrecnt Information is entered", Toast.LENGTH_SHORT).show();
        }



    }


}
