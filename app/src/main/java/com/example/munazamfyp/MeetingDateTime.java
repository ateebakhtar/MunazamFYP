package com.example.munazamfyp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.munazamfyp.Connections.AddMeetingConnections;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.date;
import com.example.munazamfyp.DataModels.time;
import com.example.munazamfyp.Pickers.DatePickerFragment;
import com.example.munazamfyp.Pickers.TimePickerFragment;

import java.util.Calendar;

public class MeetingDateTime extends AppCompatActivity {

    ImageView timer;
    ImageView cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_date_time);
        timer = findViewById(R.id.imageView1);
        cal = findViewById(R.id.imageView);
    }

    void openmain(View view)
    {
        Intent i = new Intent(this,mainmenu.class);
        startActivity(i);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        //newFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogTheme);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void OpenNext1(View view){

        date da = new date();
        time t = new time();

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        System.out.println(day+" "+month+" "+year);
        System.out.println(da.getDay()+" "+da.getMonth()+" "+da.getYear());

        if( da.getDay() < day)
        {
            if(da.getMonth() <= month)
            {
                if(da.getYear() <= year)
                {
                    ImageViewCompat.setImageTintList(cal, ColorStateList.valueOf(ContextCompat.getColor(this,R.color.errorcheck)));
                    Toast.makeText(this, "Please Enter Valid Date", Toast.LENGTH_SHORT).show();
                }
            }
        }

        if(t.getHour() == 0 && t.getMin() == 0 )
        {
            Toast.makeText(this, "Please Enter a Valid Time", Toast.LENGTH_SHORT).show();
            ImageViewCompat.setImageTintList(timer, ColorStateList.valueOf(ContextCompat.getColor(this,R.color.errorcheck)));
        }
        else if(da.getMonth() == 0 && da.getDay() == 0 && da.getYear() == 0)
        {
            ImageViewCompat.setImageTintList(timer, ColorStateList.valueOf(ContextCompat.getColor(this,R.color.correct)));
            ImageViewCompat.setImageTintList(cal, ColorStateList.valueOf(ContextCompat.getColor(this,R.color.errorcheck)));
            Toast.makeText(this, "Please Enter Valid Date", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String datee = ""+da.getDay()+" "+da.getMonth()+" "+da.getYear();
            Data.mobj.setDate(datee);
            Data.mobj.setTime(t.getMin()+" "+t.getHour());
            Intent I = new Intent(this, MeetingDescription.class);

            //new AddMeetingConnections(Data.mobj,this);
            System.out.println("hellos after meeting");
            startActivity(I);
        }


    }
}
