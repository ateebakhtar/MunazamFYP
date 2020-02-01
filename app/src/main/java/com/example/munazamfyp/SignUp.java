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
    EditText semester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void performLogin(View view)
    {
        semester = findViewById(R.id.editText12);
        name = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText3);
        id = findViewById(R.id.editText4);
        String idd = id.getText().toString();

        UserData toBeSent = new UserData();
        toBeSent.setName(name.getText().toString());
        toBeSent.setID(id.getText().toString());
        toBeSent.setPassword(pass.getText().toString());
        toBeSent.setSemester(semester.getText().toString());

        int s = Integer.parseInt(semester.getText().toString());

        if(name.getText().toString().length() < 3 || name.getText().toString() == null)
        {
            name.setError("Please Enter a Valid Name of size 3 or more");
            name.requestFocus();
        }
        else if(pass.getText().toString().length() < 8 || pass.getText().toString() == null)
        {
            pass.setError("Please Enter a Valid Password of size 8 or more");
            pass.requestFocus();
        }
        else if(id.getText().toString().length() != 7 || id.getText().toString() == null)
        {
            id.setError("Please Enter a Valid ID");
            id.requestFocus();
        }
        else if(!idd.startsWith("k") )
        {
            id.setError("Please enter id starting with k");
            id.requestFocus();
        }
        else if(s > 8)
        {
            semester.setError("Please enter a valid semester number between 1 - 8");
            semester.requestFocus();
        }
        else
        {
            new LoginConnection(toBeSent,this).execute();
        }





//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(Data.validid == "ok")
//                {
//                    Intent i = new Intent(SignUp.this,EmailVerification.class);
//                    startActivity(i);        }
//                else
//                {
//                    Toast.makeText(SignUp.this, "ID already Exist's", Toast.LENGTH_SHORT).show();
//                }
//            }
//        },3000);


//        System.out.println("l1 = "+name.getText().toString().length());
//        System.out.println("l2 = "+pass.getText().toString().length());
//        System.out.println("l3 = "+id.getText().toString().length());
//        String idd = id.getText().toString();
//        if(name.getText().toString().length() < 3 || name.getText().toString() == null)
//        {
//            name.setError("Please Enter a Valid Name of size 3 or more");
//            name.requestFocus();
//        }
//        else if(pass.getText().toString().length() < 8 || pass.getText().toString() == null)
//        {
//            pass.setError("Please Enter a Valid Password of size 8 or more");
//            pass.requestFocus();
//        }
//        else if(id.getText().toString().length() != 7 || id.getText().toString() == null)
//        {
//            id.setError("Please Enter a Valid ID");
//            id.requestFocus();
//        }
//        else if(!idd.startsWith("k") )
//        {
//            id.setError("Please enter id starting with k");
//            id.requestFocus();
//        }
//        else if(name.getText().toString().length() >= 3 && pass.getText().toString().length() >=8 && id.getText().toString().length() >= 7)
//        {
//            UserData toBeSent = new UserData();
//            toBeSent.setName(name.getText().toString());
//            toBeSent.setID(id.getText().toString());
//            toBeSent.setPassword(pass.getText().toString());
//
//            new LoginConnection(toBeSent).execute();
//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if(Data.validid == "ok")
//                    {
//                        Intent i = new Intent(SignUp.this,EmailVerification.class);
//                        startActivity(i);        }
//                    else
//                    {
//                        Toast.makeText(SignUp.this, "ID already Exist's", Toast.LENGTH_SHORT).show();
//                    }
//                    finish();
//                }
//            },3000);
//
//
//        }
//        else
//        {
//            Toast.makeText(this, "Incorrecnt Information is entered", Toast.LENGTH_SHORT).show();
//        }



    }


}
