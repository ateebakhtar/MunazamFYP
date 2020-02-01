package com.example.munazamfyp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.munazamfyp.Connections.ForgotPassConnection;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void forogtpass(View view)
    {
        EditText id = findViewById(R.id.editText13);
        String idd = id.getText().toString();
        if(id.getText().toString().length() != 7 || id.getText().toString() == null)
        {
            id.setError("Please Enter a Valid ID");
            id.requestFocus();
        }
        else if(!idd.startsWith("k") )
        {
            id.setError("Please enter id starting with k");
            id.requestFocus();
        }
        else
        {
            new ForgotPassConnection(this,idd).execute();
            Intent i = new Intent(this,Login.class);
            Toast.makeText(this, "Password has been sent to your University Email", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
    }
}
