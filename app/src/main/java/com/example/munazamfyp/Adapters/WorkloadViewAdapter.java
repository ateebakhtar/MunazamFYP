package com.example.munazamfyp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.DataModels.WorkloadViewModel;
import com.example.munazamfyp.DetailedWorkload;
import com.example.munazamfyp.R;

import java.util.ArrayList;

public class WorkloadViewAdapter extends RecyclerView.Adapter<WorkloadViewAdapter.ExampleViewHolder>
{
    private ArrayList<WorkloadViewModel> mpaymentlist;
    private ExampleViewHolder holder;
    private int position;
    private Context mContext;
    public View parentLayout;
    WorkloadViewAdapter()
    {

    }
    WorkloadViewAdapter(Context x)
    {
        mContext = x;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {

        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView a;
        public ImageView a1;
        public ImageView a2;
        public ImageView a3;
        public EditText ab;



        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            a = itemView.findViewById(R.id.imageView2);
            a1 = itemView.findViewById(R.id.imageView3);
            a2 = itemView.findViewById(R.id.imageView4);
            a3 = itemView.findViewById(R.id.imageView5);
            ab = itemView.findViewById(R.id.editText2);


        }




    }
    public WorkloadViewAdapter(ArrayList<WorkloadViewModel> exampleItemArrayList, Context x)
    {
        mpaymentlist =exampleItemArrayList;
        mContext = x;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.workload_item,viewGroup,false);
        ExampleViewHolder evh=new ExampleViewHolder(v);
        return evh;
    }



    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, final int i) {

        WorkloadViewModel currentItem=mpaymentlist.get(i);


        exampleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Recycle Click" , Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(view.getContext(), DetailedWorkload.class);
                Context c = view.getContext();
                System.out.println("pos = "+i);
                Bundle x = new Bundle();
                x.putInt("pos",i);
                i1.putExtras(x);
                c.startActivity(i1);
            }
        });

        exampleViewHolder.ab.setClickable(false);
        exampleViewHolder.ab.setFocusable(false);


        if(currentItem.getImageResource1().equals("a0"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.a);
        }
        else        {
            exampleViewHolder.a.setImageResource(R.drawable.a1);
        }

        if(currentItem.getImageResource2().equals("q0"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.q);
        }
        else        {
            exampleViewHolder.a1.setImageResource(R.drawable.q1);
        }

        if(currentItem.getImageResource3().equals("p0"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.p);
        }
        else        {
            exampleViewHolder.a2.setImageResource(R.drawable.p1);
        }

        if(currentItem.getImageResource4().equals("e0"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.e);
        }
        else        {
            exampleViewHolder.a3.setImageResource(R.drawable.e1);
        }

        exampleViewHolder.ab.setText(currentItem.getEdittext1());
    }

    @Override
    public int getItemCount() {
        return mpaymentlist.size();
    }
}
