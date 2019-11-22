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

import com.example.munazamfyp.DataModels.Example_item;
import com.example.munazamfyp.DetailedWorkload;
import com.example.munazamfyp.R;

import java.util.ArrayList;

public class WorkloadViewAdapter extends RecyclerView.Adapter<WorkloadViewAdapter.ExampleViewHolder>
{
    private ArrayList<Example_item> mpaymentlist;
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
            ab=itemView.findViewById(R.id.editText2);


        }




    }
    public WorkloadViewAdapter(ArrayList<Example_item> exampleItemArrayList, Context x)
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

        Example_item currentItem=mpaymentlist.get(i);


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

        if(currentItem.getImageResource1().equals("a0"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.a);
        }
        if(currentItem.getImageResource1().equals("a1"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.a1);
        }
        if(currentItem.getImageResource1().equals("e0"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.e);
        }
        if(currentItem.getImageResource1().equals("e1"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.e1);
        }
        if(currentItem.getImageResource1().equals("p0"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.p);
        }
        if(currentItem.getImageResource1().equals("p1"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.p1);
        }
        if(currentItem.getImageResource1().equals("q0"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.q);
        }
        if(currentItem.getImageResource1().equals("q1"))
        {
            exampleViewHolder.a.setImageResource(R.drawable.q1);
        }




        if(currentItem.getImageResource2().equals("a0"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.a);
        }
        if(currentItem.getImageResource2().equals("a1"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.a1);
        }
        if(currentItem.getImageResource2().equals("e0"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.e);
        }
        if(currentItem.getImageResource2().equals("e1"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.e1);
        }
        if(currentItem.getImageResource2().equals("p0"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.p);
        }
        if(currentItem.getImageResource2().equals("p1"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.p1);
        }
        if(currentItem.getImageResource2().equals("q0"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.q);
        }
        if(currentItem.getImageResource2().equals("q1"))
        {
            exampleViewHolder.a1.setImageResource(R.drawable.q1);
        }









        if(currentItem.getImageResource3().equals("a0"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.a);
        }
        if(currentItem.getImageResource3().equals("a1"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.a1);
        }
        if(currentItem.getImageResource3().equals("e0"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.e);
        }
        if(currentItem.getImageResource3().equals("e1"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.e1);
        }
        if(currentItem.getImageResource3().equals("p0"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.p);
        }
        if(currentItem.getImageResource3().equals("p1"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.p1);
        }
        if(currentItem.getImageResource3().equals("q0"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.q);
        }
        if(currentItem.getImageResource3().equals("q1"))
        {
            exampleViewHolder.a2.setImageResource(R.drawable.q1);
        }




        if(currentItem.getImageResource4().equals("a0"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.a);
        }
        if(currentItem.getImageResource4().equals("a1"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.a1);
        }
        if(currentItem.getImageResource4().equals("e0"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.e);
        }
        if(currentItem.getImageResource4().equals("e1"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.e1);
        }
        if(currentItem.getImageResource4().equals("p0"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.p);
        }
        if(currentItem.getImageResource4().equals("p1"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.p1);
        }
        if(currentItem.getImageResource4().equals("q0"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.q);
        }
        if(currentItem.getImageResource4().equals("q1"))
        {
            exampleViewHolder.a3.setImageResource(R.drawable.q1);
        }




        exampleViewHolder.ab.setText(currentItem.getEdittext1());






    }

    @Override
    public int getItemCount() {
        return mpaymentlist.size();
    }
}
