package com.example.munazamfyp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.Connections.UpdateWorkloadConnection;
import com.example.munazamfyp.Connections.WorkloadConnection;
import com.example.munazamfyp.ContinueAs;
import com.example.munazamfyp.DataModels.WorkloadDetailModel;
import com.example.munazamfyp.Login;
import com.example.munazamfyp.MainActivity;
import com.example.munazamfyp.R;
import com.example.munazamfyp.SplashScreen;

import java.util.ArrayList;
import java.util.logging.LogRecord;

public class WorkloadDetailAdapter extends RecyclerView.Adapter<WorkloadDetailAdapter.ExampleViewHolder>
{
    private ArrayList<WorkloadDetailModel> mpaymentlist1;
    private int position;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView a;
        public EditText ab;
        public TextView type;
        public TextView name;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            ExampleViewHolder exampleViewHolder;
            a = itemView.findViewById(R.id.imageView2);
            ab = itemView.findViewById(R.id.editText2);
            type=itemView.findViewById(R.id.textView);
            name=itemView.findViewById(R.id.textView2);
        }
    }

    public WorkloadDetailAdapter(ArrayList<WorkloadDetailModel> exampleItemArrayList) {
        mpaymentlist1 = exampleItemArrayList;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.workload_details, viewGroup, false);

        ExampleViewHolder evh = new ExampleViewHolder(v);

        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, int position)
    {
        final WorkloadDetailModel currentItem = mpaymentlist1.get(position);

        holder.ab.setText(currentItem.getEdittext1());
        holder.type.setText(currentItem.getEdittext2());
        holder.name.setText(currentItem.getEdittext3());
        final Context c = holder.itemView.getContext();

        holder.ab.setClickable(false);
        holder.ab.setFocusable(false);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Toast.makeText(view.getContext(), "Recycle Click" , Toast.LENGTH_SHORT).show();

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                UpdateWorkloadConnection OP = new UpdateWorkloadConnection(currentItem.getId(),c);
                                OP.execute();
                                new WorkloadConnection(view.getContext()).execute();

                                //Yes button clicked
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setMessage("Mark as Done").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();

            }
        });

        if (currentItem.getImageResource().equals("a1")) {

            holder.a.setImageResource(R.drawable.a1);
        }
        else if (currentItem.getImageResource().equals("p1")) {

            holder.a.setImageResource(R.drawable.p1);
        }
        else if (currentItem.getImageResource().equals("q1")) {

            holder.a.setImageResource(R.drawable.q1);
        }
        else if (currentItem.getImageResource().equals("e1")) {

            holder.a.setImageResource(R.drawable.e1);
        }

    }



    @Override
    public int getItemCount() {
        return mpaymentlist1.size();
    }
}


