package com.example.munazamfyp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
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
    TextView[] cours = new TextView[7];

    //public TunerAdapter(List<TunerModel> movieList) {
//        this.tunerlist = movieList;
//    }
    Context cx;

    public TunerAdapter(List<Integer> movieList,List<Boolean> expandede,Context context) {

        this.expandede = expandede;
        cx = context;
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



        switch (sizer.get(position))
        {
            case 1:
                String[] courses = cx.getResources().getStringArray(R.array.s1);
                for(int i=0;i<courses.length;i++)
                {
                    //System.out.printf(courses[i]);
                    cours[i].setText(courses[i]);
                }
                break;
            case 2:
                String[] courses1 = cx.getResources().getStringArray(R.array.s2);
                for(int i=0;i<courses1.length;i++)
                {
                    //System.out.printf(courses1[i]);
                    cours[i].setText(courses1[i]);
                }
                break;
            case 3:
                String[] courses2 = cx.getResources().getStringArray(R.array.s3);
                for(int i=0;i<courses2.length;i++)
                {
                    //System.out.printf(courses[i]);
                    cours[i].setText(courses2[i]);
                }
                break;
            case 4:
                String[] courses3 = cx.getResources().getStringArray(R.array.s4);
                for(int i=0;i<courses3.length;i++)
                {
                    //System.out.printf(courses[i]);
                    cours[i].setText(courses3[i]);
                }
                break;
            case 5:
                String[] courses4 = cx.getResources().getStringArray(R.array.s5);
                for(int i=0;i<courses4.length;i++)
                {
                    //System.out.printf(courses[i]);
                    cours[i].setText(courses4[i]);
                }
                break;
            case 6:
                String[] courses5 = cx.getResources().getStringArray(R.array.s6);
                for(int i=0;i<courses5.length;i++)
                {
                    //System.out.printf(courses[i]);
                    cours[i].setText(courses5[i]);
                }
                break;
            case 7:
                String[] courses6 = cx.getResources().getStringArray(R.array.s7);
                for(int i=0;i<courses6.length;i++)
                {
                    //System.out.printf(courses[i]);
                    cours[i].setText(courses6[i]);
                }
                break;
            case 8:
                String[] courses7 = cx.getResources().getStringArray(R.array.s8);
                for(int i=0;i<courses7.length;i++)
                {
                    System.out.printf(courses7[i]);
                    cours[i].setText(courses7[i]);
                }
                break;
        }

//        if(sizer.get(position) == 1)
//        {
//            String[] courses = cx.getResources().getStringArray(R.array.s1);
//            for(int i=0;i<courses.length;i++)
//            {
//                System.out.printf(courses[i]);
//                cours[i].setText(courses[i]);
//            }
//        }

        boolean isExpanded = expandede.get(position);
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return sizer.size();
    }

    class TunerAH extends RecyclerView.ViewHolder {

        private static final String TAG = "TunerAH";

        Spinner x;

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

        //TextView[] cours = new TextView[7];


        ConstraintLayout expandableLayout;


        public TunerAH(@NonNull final View itemView) {
            super(itemView);

            cgpa = itemView.findViewById(R.id.textView28);
            sgpa = itemView.findViewById(R.id.textView30);
            semester = itemView.findViewById(R.id.textView25);
            expandableLayout = itemView.findViewById(R.id.constraintLayout3);

            cours[0] = itemView.findViewById(R.id.textView31);
            cours[1] = itemView.findViewById(R.id.textView32);
            cours[2] = itemView.findViewById(R.id.textView33);
            cours[3] = itemView.findViewById(R.id.textView34);
            cours[4] = itemView.findViewById(R.id.textView35);
            cours[5] = itemView.findViewById(R.id.textView36);
            cours[6] = itemView.findViewById(R.id.textView52);


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
