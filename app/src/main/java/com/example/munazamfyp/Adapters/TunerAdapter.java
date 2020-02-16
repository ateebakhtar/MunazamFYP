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
    List<Boolean> expandede;
    List<Integer> sizer;

    //public TunerAdapter(List<TunerModel> movieList) {
//        this.tunerlist = movieList;
//    }


    public TunerAdapter(List<Integer> movieList,List<Boolean> expandede) {

        this.expandede = expandede;
        this.sizer = movieList;
    }
    @NonNull
    @Override
    public TunerAH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tuner_template, parent, false);
        return new TunerAH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TunerAH holder, int position) {

        //holder.cgpa.setText(tunerlist.get(position).getCgpa());

        holder.semester.setText("Semester: "+sizer.get(position));

        boolean isExpanded = expandede.get(position);
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return sizer.size();
    }

    class TunerAH extends RecyclerView.ViewHolder {

        private static final String TAG = "TunerAH";

        TextView cgpa;
        TextView sgpa;
        TextView semester;
        TextView course1;
        TextView course2;
        TextView course3;
        TextView course4;
        TextView course5;
        TextView course6;
        TextView course7;



        ConstraintLayout expandableLayout;


        public TunerAH(@NonNull final View itemView) {
            super(itemView);

            cgpa = itemView.findViewById(R.id.textView28);
            sgpa = itemView.findViewById(R.id.textView30);
            semester = itemView.findViewById(R.id.textView25);
            expandableLayout = itemView.findViewById(R.id.constraintLayout3);

            course1 = itemView.findViewById(R.id.textView31);
            course2 = itemView.findViewById(R.id.textView32);
            course3 = itemView.findViewById(R.id.textView33);
            course4 = itemView.findViewById(R.id.textView34);
            course5 = itemView.findViewById(R.id.textView35);
            course6 = itemView.findViewById(R.id.textView36);
            course7 = itemView.findViewById(R.id.textView52);


            semester.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    TunerModel tuner = tunerlist.get(getAdapterPosition());
//                    tuner.setExpanded(!tuner.isExpanded());
//                    notifyItemChanged(getAdapterPosition());
                    boolean x = expandede.get(getAdapterPosition());
                    expandede.set(getAdapterPosition(),!x);
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
