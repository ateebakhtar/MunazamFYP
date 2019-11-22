package com.example.munazamfyp.Adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.EnterReminder;
import com.example.munazamfyp.MainActivity;
import com.example.munazamfyp.R;
import com.example.munazamfyp.DataModels.ReminderItem;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ExampleViewHolder>
{
    public ArrayList<ReminderModel> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public ReminderAdapter(ArrayList<ReminderModel> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ReminderAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ReminderAdapter.ExampleViewHolder evh=new ReminderAdapter.ExampleViewHolder(v);
        return evh;

    }



    @Override
    public void onBindViewHolder(ReminderAdapter.ExampleViewHolder holder, int position) {
        ReminderModel currentItem = mExampleList.get(position);

        if(currentItem.getType().equals("Assignment"))
        {
            holder.mImageView.setImageResource(R.drawable.a1);
        }
        else if(currentItem.getType().equals("Project"))
        {
            holder.mImageView.setImageResource(R.drawable.p1);
        }
        else if(currentItem.getType().equals("Quiz"))
        {
            holder.mImageView.setImageResource(R.drawable.q1);
        }
        else if(currentItem.getType().equals("Midterm"))
        {
            holder.mImageView.setImageResource(R.drawable.e1);
        }
        else
        {
            holder.mImageView.setImageResource(R.drawable.a1);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Recycle Click" , Toast.LENGTH_SHORT).show();
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //edit button clicked
                                //open enter reminder screen
                                //remove the item aswell
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //delete button clicked
                                //open reminder screen
                                break;
                        }
                    }
                };
                Context c = view.getContext();
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setMessage("Do you Want to Edit or Delete").setPositiveButton("Edit", dialogClickListener)
                        .setNegativeButton("Delete", dialogClickListener).show();

            }
        });

        holder.mTextView1.setText(currentItem.getCoursename());
        holder.mTextView2.setText(currentItem.getDate());
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
