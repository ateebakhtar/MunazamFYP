package com.example.munazamfyp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.munazamfyp.Connections.GetCourses;
import com.example.munazamfyp.Connections.SetReminderConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.ReminderData;
import com.example.munazamfyp.DataModels.ReminderItem;
import com.example.munazamfyp.DataModels.date;
import com.example.munazamfyp.DataModels.time;
import com.example.munazamfyp.Pickers.DatePickerFragment;
import com.example.munazamfyp.Pickers.TimePickerFragment;

import static com.example.munazamfyp.R.drawable.a1;

public class EnterReminder extends AppCompatActivity {


    Spinner spin;
    Spinner spin1;

    ImageButton assignment;
    ImageButton quiz;
    ImageButton exam;
    ImageButton project;

    String selected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_reminder);

        getSupportActionBar().hide();

        assignment = findViewById(R.id.imageButton3);
        quiz = findViewById(R.id.imageButton6);
        exam = findViewById(R.id.imageButton4);
        project = findViewById(R.id.imageButton5);

//        spin = (Spinner) findViewById(R.id.spinner);
//        String[] objects = { "Assignment", "Project", "Quiz", "Midterm"};
//        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects);
//        spin.setAdapter(adapter);

        new GetCourses(this,"asd","1").execute();

        spin1 = (Spinner) findViewById(R.id.spinner2);

        Handler handler =new Handler();
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,getResources().getStringArray(R.array.s1) );


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println(":in the handler");
                System.out.println("sideewgqg "+Data.courses.size());
                final String[] obj = new String[Data.x1.size()];
                for(int i=0;i<Data.x1.size();i++)
                {
                    System.out.println("Loopingg");
                    obj[i] = Data.x1.get(i).getName();
                    System.out.println("wtf "+obj[i]);
                }

                // System.out.println("Data"+Data.courses.get(2).getName());
                ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,obj );

                //spin1.setAdapter(adapter1);
            }
        },1000);


        spin1.setAdapter(adapter1);
    }
    float ele = 35;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onassign(View view)
    {
        if(selected != null)
        {
            Toast.makeText(this, "Please Select only one Task", Toast.LENGTH_SHORT).show();
        }
        selected = "Assignment";
        assignment.setImageResource(a1);
        quiz.setImageResource(R.drawable.q);
        exam.setImageResource(R.drawable.e);
        project.setImageResource(R.drawable.p);
        quiz.setElevation(ele);
        exam.setElevation(ele);
        project.setElevation(ele);
        assignment.setElevation(0);
        Toast.makeText(this, "Assignment", Toast.LENGTH_SHORT).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onproject(View view)
    {
        if(selected != null)
        {
            Toast.makeText(this, "Please Select only one Task", Toast.LENGTH_SHORT).show();
        }
        selected = "Project";
        assignment.setImageResource(R.drawable.a);
        quiz.setImageResource(R.drawable.q);
        exam.setImageResource(R.drawable.e);
        project.setImageResource(R.drawable.p1);
        quiz.setElevation(ele);
        exam.setElevation(ele);
        project.setElevation(0);
        assignment.setElevation(ele);
        Toast.makeText(this, "Project", Toast.LENGTH_SHORT).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onexam(View view)
    {
        if(selected != null)
        {
            Toast.makeText(this, "Please Select only one Task", Toast.LENGTH_SHORT).show();
        }
        selected = "Midterm";
        assignment.setImageResource(R.drawable.a);
        quiz.setImageResource(R.drawable.q);
        exam.setImageResource(R.drawable.e1);
        project.setImageResource(R.drawable.p);
        quiz.setElevation(ele);
        exam.setElevation(0);
        project.setElevation(ele);
        assignment.setElevation(ele);
        Toast.makeText(this, "Exam", Toast.LENGTH_SHORT).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onquiz(View view)
    {
        if(selected != null)
        {
            Toast.makeText(this, "Please Select only one Task", Toast.LENGTH_SHORT).show();
        }
        selected = "Quiz";
        assignment.setImageResource(R.drawable.a);
        quiz.setImageResource(R.drawable.q1);
        exam.setImageResource(R.drawable.e);
        project.setImageResource(R.drawable.p);
        quiz.setElevation(0);
        exam.setElevation(ele);
        project.setElevation(ele);
        assignment.setElevation(ele);
        Toast.makeText(this, "Quiz", Toast.LENGTH_SHORT).show();
    }

    public void OpenNext(View view)
    {

        ReminderData d = new ReminderData();
        d.setCourse(spin1.getSelectedItem().toString());
        d.setTopic(selected);

        if(selected == null)
        {
            Toast.makeText(this, "Please Select a Task", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent I = new Intent(this, DataTimeScreen.class);
            startActivity(I);
        }

    }

}
