package com.example.munazamfyp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.DataModels.TunerModel;
import com.example.munazamfyp.R;

import java.util.List;

public class TunerAdapter extends RecyclerView.Adapter<TunerAdapter.TunerAH>
{
    private static final String TAG = "MovieAdapter";
    List<TunerModel> tunerlist;

    public TunerAdapter(List<TunerModel> movieList) {
        this.tunerlist = movieList;
    }

    @NonNull
    @Override
    public TunerAH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tuner_template, parent, false);
        return new TunerAH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TunerAH holder, int position) {

        holder.cgpa.setText(tunerlist.get(position).getCgpa());

        boolean isExpanded = tunerlist.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return tunerlist.size();
    }

    class TunerAH extends RecyclerView.ViewHolder {

        private static final String TAG = "TunerAH";

        TextView cgpa;
        TextView sgpa;
        TextView semester;
        TextView grade1;
        TextView grade2;
        TextView grade3;
        TextView grade4;
        TextView grade5;
        TextView grade6;



        ConstraintLayout expandableLayout;


        public TunerAH(@NonNull final View itemView) {
            super(itemView);

            cgpa = itemView.findViewById(R.id.textView28);
            sgpa = itemView.findViewById(R.id.textView30);
            semester = itemView.findViewById(R.id.textView25);
            expandableLayout = itemView.findViewById(R.id.constraintLayout3);

            semester.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    TunerModel tuner = tunerlist.get(getAdapterPosition());
                    tuner.setExpanded(!tuner.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
