package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

        UserData toBeSent = new UserData();
        toBeSent.setName(name.getText().toString());
        toBeSent.setID(id.getText().toString());
        toBeSent.setPassword(pass.getText().toString());


        new LoginConnection(toBeSent).execute();
  //      LoginConnection x = new LoginConnection(toBeSent);
        //x.backx();
//        x.onPostExecute();

        Intent i = new Intent(this,EmailVerification.class);
        startActivity(i);

    }


}
