package com.example.munazamfyp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.DataModels.TunerModel;
import com.example.munazamfyp.R;

import java.text.DecimalFormat;
import java.util.List;

public class TunerAdapter extends RecyclerView.Adapter<TunerAdapter.TunerAH>
{
    private static final String TAG = "MovieAdapter";
    List<TunerModel> tunerlist;
    List<Boolean> expandede;
    List<Integer> sizer;
    static int flag = 0;
    TextView[] cours = new TextView[7];
    public static double[] val = new double[60];

    public static void setNewval(double[] newval) {
        TunerAdapter.newval = newval;
    }

    public static double[] newval = new double[60];


    public double[] getVal()
    {
        return val;
    }


    //public TunerAdapter(List<TunerModel> movieList) {
//        this.tunerlist = movieList;
//    }
    Context cx;
    public void setflag(int i)
    {
        flag = i;
    }
    public TunerAdapter(List<Integer> movieList,List<Boolean> expandede,Context context,int flag) {

        this.flag = flag;
        this.expandede = expandede;
        cx = context;
        this.sizer = movieList;

        for(int i=0;i<60;i++)
        {
            newval[i] = -1;
            val[i] = -1;
        }
    }
    @NonNull
    @Override
    public TunerAH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tuner_template, parent, false);
        return new TunerAH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TunerAH holder, int position) {

        //holder.cgpa.setText(tunerlist.get(position).getCgpa());

        holder.semester.setText("Semester: "+sizer.get(position));

        final String[] obj = {"0.00","1.00","1.33","1.67","2.00","2.33","2.67","3.00","3.33","3.67","4.00"};


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


        ArrayAdapter aa0 = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);
        ArrayAdapter aa1 = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);
        ArrayAdapter aa2 = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);
        ArrayAdapter aa3 = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);
        ArrayAdapter aa4 = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);
        ArrayAdapter aa5 = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);
        ArrayAdapter aa6 = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);
        ArrayAdapter aa = new ArrayAdapter(cx,android.R.layout.simple_spinner_item,obj);

        final int temp = position;

        holder.spins[0].setAdapter(aa0);
        holder.spins[1].setAdapter(aa1);
        holder.spins[2].setAdapter(aa2);
        holder.spins[3].setAdapter(aa3);
        holder.spins[4].setAdapter(aa4);
        holder.spins[5].setAdapter(aa5);
        holder.spins[6].setAdapter(aa6);




        boolean isExpanded = expandede.get(position);
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println(flag+" flagg");
        if(flag > 0)
        {
            System.out.println("Flagging the way"+newval[7*temp]);

            holder.grades[0].setText(""+df.format(newval[7*temp]));
            holder.grades[1].setText(""+df.format(newval[7*temp+1]));
            holder.grades[2].setText(""+df.format(newval[7*temp+2]));
            holder.grades[3].setText(""+df.format(newval[7*temp+3]));
            holder.grades[4].setText(""+df.format(newval[7*temp+4]));
            holder.grades[5].setText(""+df.format(newval[7*temp+5]));
            holder.grades[6].setText(""+df.format(newval[7*temp+6]));

            flag--;
            return;
        }



        holder.spins[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                System.out.println(temp);

                val[7*temp] = Double.parseDouble(obj[position]);
                holder.grades[0].setText(obj[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        holder.spins[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                val[7*temp+1] = Double.parseDouble(obj[position]);
                holder.grades[1].setText(""+obj[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        holder.spins[2].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                val[7*temp+2] = Double.parseDouble(obj[position]);
                holder.grades[2].setText(obj[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        holder.spins[3].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                val[7*temp+3] = Double.parseDouble(obj[position]);
                holder.grades[3].setText(obj[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        holder.spins[4].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                val[7*temp+4] = Double.parseDouble(obj[position]);
                holder.grades[4].setText(obj[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        holder.spins[5].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                val[7*temp+5] = Double.parseDouble(obj[position]);
                holder.grades[5].setText(obj[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        holder.spins[6].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                val[7*temp+6] = Double.parseDouble(obj[position]);
                holder.grades[6].setText(obj[position]);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });







    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        Button calculategpa;
        TextView[] grades = new TextView[7];
        Spinner[] spins = new Spinner[7];




        //TextView[] cours = new TextView[7];


        ConstraintLayout expandableLayout;


        public TunerAH(@NonNull final View itemView) {
            super(itemView);

            cgpa = itemView.findViewById(R.id.textView28);
            sgpa = itemView.findViewById(R.id.textView30);
            semester = itemView.findViewById(R.id.textView25);
            expandableLayout = itemView.findViewById(R.id.constraintLayout3);
            calculategpa = itemView.findViewById(R.id.button20);

            cours[0] = itemView.findViewById(R.id.textView44);
            cours[1] = itemView.findViewById(R.id.textView31);
            cours[2] = itemView.findViewById(R.id.textView34);
            cours[3] = itemView.findViewById(R.id.textView35);
            cours[4] = itemView.findViewById(R.id.textView36);
            cours[5] = itemView.findViewById(R.id.textView33);
            cours[6] = itemView.findViewById(R.id.textView32);

            spins[0]=itemView.findViewById(R.id.spinner5);
            spins[1]=itemView.findViewById(R.id.spinner6);
            spins[2]=itemView.findViewById(R.id.spinner7);
            spins[3]=itemView.findViewById(R.id.spinner8);
            spins[4]=itemView.findViewById(R.id.spinner9);
            spins[5]=itemView.findViewById(R.id.spinner10);
            spins[6]=itemView.findViewById(R.id.spinner11);

            grades[0] = itemView.findViewById(R.id.textView37);
            grades[1] = itemView.findViewById(R.id.textView38);
            grades[2] = itemView.findViewById(R.id.textView39);
            grades[3] = itemView.findViewById(R.id.textView40);
            grades[4] = itemView.findViewById(R.id.textView41);
            grades[5] = itemView.findViewById(R.id.textView42);
            grades[6] = itemView.findViewById(R.id.textView43);

            calculategpa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                double[] arr = new double[7];
                double[] cr = {1,3,1,3,3,3,3};
                    System.out.println(getAdapterPosition());
                for(int i=0;i<7;i++)
                {
                    arr[i] = Double.parseDouble(grades[i].getText().toString());
                    System.out.println(arr[i]);

                }
                GPASuggestion x = new GPASuggestion();
                double gpa = x.calculate(arr,cr);
                sgpa.setText(""+gpa);

                gpa = x.calculate(val,val);
                cgpa.setText(""+gpa);
                }
            });


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
