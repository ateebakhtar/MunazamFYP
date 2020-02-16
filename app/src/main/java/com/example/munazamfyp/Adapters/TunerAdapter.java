package com.example.munazamfyp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.DataModels.TunerModel;
import com.example.munazamfyp.Fragments.TunerView;
import com.example.munazamfyp.R;

import java.util.List;

public class TunerAdapter extends RecyclerView.Adapter<TunerAdapter.TunerAH>
{
    private static final String TAG = "MovieAdapter";
    List<TunerModel> tunerlist;
    List<Boolean> expandede;
    List<Integer> sizer;
    String[] GPA = { "1", "1.33", "1.67", "2", "2.33","2.67","3","3.33","3.67","4"};

    //public TunerAdapter(List<TunerModel> movieList) {
//        this.tunerlist = movieList;
//    }


    Context ca;
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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


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
        Spinner  course1a;
        Spinner  course2a;
        Spinner  course3a;
        Spinner  course4a;
        Spinner  course5a;
        Spinner  course6a;
        Spinner  course7a;



        ConstraintLayout expandableLayout;


        public TunerAH(@NonNull final View itemView) {
            super(itemView);
            ArrayAdapter aa = new ArrayAdapter(this, and.simple_spinner_item,GPA );
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);

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
            course1a=itemView.findViewById(R.id.spinner8);
            course2a=itemView.findViewById(R.id.spinner9);
            course3a=itemView.findViewById(R.id.spinner10);
            course4a=itemView.findViewById(R.id.spinner11);
            course5a=itemView.findViewById(R.id.spinner12);
            course6a=itemView.findViewById(R.id.spinner7);
            course7a=itemView.findViewById(R.id.spinner13);





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
