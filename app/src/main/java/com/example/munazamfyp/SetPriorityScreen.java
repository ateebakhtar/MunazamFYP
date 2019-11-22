package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.munazamfyp.Connections.SetReminderConnection;
import com.example.munazamfyp.DataModels.ReminderData;
import com.example.munazamfyp.DataModels.ReminderItem;
import com.example.munazamfyp.DataModels.date;
import com.example.munazamfyp.DataModels.time;

public class SetPriorityScreen extends AppCompatActivity {
    private static SeekBar seekBar;
    private static TextView textView;
    int progressValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_priority_screen);
        seekbar();
    }
    public void seekbar(){

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView4);
        textView.setText("Selection is: " + seekBar.getProgress() + "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {


                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        textView.setText("Selection is: " + progress + "/" + seekBar.getMax());
                        Toast.makeText(SetPriorityScreen.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(SetPriorityScreen.this, "SeekBar in startTracking", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        textView.setText("Selection is: " + progressValue + "/" + seekBar.getMax());
                        Toast.makeText(SetPriorityScreen.this, "SeekBar in stopTracking", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void openlist(View view)
    {
        ReminderData d = new ReminderData();
        String CN = d.getCourse();
        String type = d.getTopic();

        date da = new date();
        time t = new time();

        String date1 = da.getDay()+" "+da.getMonth();
        String t1 = t.getMin()+" : "+t.getHour();

        ReminderItem ri = new ReminderItem();
        ri.put(date1,t1,type,CN,"1");
        if(progressValue == 0)
        {
            progressValue = 1;
        }
        SetReminderConnection x = new SetReminderConnection(ri,""+progressValue);
        x.execute();

        Intent i = new Intent(this,ReminderView.class);
        startActivity(i);
    }
}
