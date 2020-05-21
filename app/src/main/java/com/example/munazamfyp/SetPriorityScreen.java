package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.munazamfyp.Connections.ReminderDeleteConnection;
import com.example.munazamfyp.Connections.SetReminderConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.ReminderData;
import com.example.munazamfyp.DataModels.ReminderItem;
import com.example.munazamfyp.DataModels.date;
import com.example.munazamfyp.DataModels.time;
import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;

public class SetPriorityScreen extends AppCompatActivity {
    private static SeekBar seekBar;
    private static TextView textView;
    ArcSeekBar ASB;
    int progressValue;
    String nam = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_priority_screen);

        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        nam = sharedpreferences.getString("name","x");

        seekbar();
    }
    public void seekbar(){

        textView = (TextView) findViewById(R.id.textView4);
        ASB = findViewById(R.id.seekArc);


        int[] color = getResources().getIntArray(R.array.gradident);
        ASB.setProgressGradient(color);

        ASB.setOnProgressChangedListener(
                new ProgressListener() {
                    @Override
                    public void invoke(int i) {
                        if(i > 0 && i <= 20)
                        {
                            progressValue = 1;
                            textView.setText("Selection is: " + 1 + "/ 5"  );
                        }
                        else if(i > 20 && i <= 40)
                        {
                            progressValue = 2;
                            textView.setText("Selection is: " + 2 + "/ 5" );
                        }
                        else if(i > 40 && i <= 60)
                        {
                            progressValue = 3;
                            textView.setText("Selection is: " + 3 + "/ 5" );
                        }
                        else if(i > 60 && i <= 80)
                        {
                            progressValue = 4;
                            textView.setText("Selection is: " + 4 + "/ 5" );
                        }
                        else
                        {
                            progressValue = 5;
                            textView.setText("Selection is: " + 5 + "/ 5" );
                        }
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

        final ReminderItem ri = new ReminderItem();
         ri.put(date1,t1,type,CN,"1");
        if(progressValue == 0)
        {
            progressValue = 1;
        }
        if(Data.RID != null)
        {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            //edit button clicked
                            //open enter reminder screen
                            //remove the item aswell


                            SetReminderConnection x = new SetReminderConnection(ri,""+progressValue,SetPriorityScreen.this,nam);
                            x.execute();

                            System.out.println("dadadada" + Data.RID);

                            ReminderDeleteConnection s1 = new ReminderDeleteConnection(Data.RID,SetPriorityScreen.this);
                            s1.execute();
                            Data.RID = null;

                            Intent i = new Intent(SetPriorityScreen.this,ReminderView.class);
                            startActivity(i);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //delete button clicked
                            //open reminder screen
                            SetReminderConnection x1 = new SetReminderConnection(ri,""+progressValue,SetPriorityScreen.this,nam);
                            x1.execute();
                            Data.RID = null;

                            Intent i1 = new Intent(SetPriorityScreen.this,ReminderView.class);
                            startActivity(i1);
                            break;
                    }
                }
            };
            Context c = view.getContext();
            AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setMessage("Do you wish to override your previous Reminder? ").setPositiveButton("Yes Override", dialogClickListener)
                    .setNegativeButton("No, Enter as Seperate", dialogClickListener).show();
            //Data.RID = null;
        }
        else
        {
            SetReminderConnection x = new SetReminderConnection(ri,""+progressValue,SetPriorityScreen.this,nam);
            x.execute();

            Intent i = new Intent(this,mainmenu.class);
            startActivity(i);
        }

    }
}
