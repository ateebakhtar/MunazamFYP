package com.example.munazamfyp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.munazamfyp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PredictorView extends Fragment
{
    public static PredictorView newInstance()
    {
        return new PredictorView();
    }

    View root;
    EditText c1;
    EditText c2;
    EditText c3;
    EditText finalgrade;
    EditText c4;
    Spinner grade1,grade2,grade3;

    EditText q1,q2,q3;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.predictor_activity, container, false);

        c1 = root.findViewById(R.id.mymark1);
        c2 = root.findViewById(R.id.mymark2);
        c3 = root.findViewById(R.id.mymark3);
        c4 = root.findViewById(R.id.mymark);

        grade1 = root.findViewById(R.id.spin1);
        grade2 = root.findViewById(R.id.spin2);
        grade3 = root.findViewById(R.id.spin3);

        finalgrade = root.findViewById(R.id.finalgrade);

        q1 = root.findViewById(R.id.totalmark1);
        q2 = root.findViewById(R.id.totalmark2);
        q3 = root.findViewById(R.id.totalmark3);

        q1.setFocusable(false);
        q1.setClickable(false);
        q2.setFocusable(false);
        q2.setClickable(false);
        q3.setFocusable(false);
        q3.setClickable(false);
        finalgrade.setFocusable(false);
        finalgrade.setClickable(false);

        String[] objects = {"A","A-","B+","B","B-","C+","C","C-","D+", "D"};


        ArrayAdapter adapter = new ArrayAdapter(root.getContext(), android.R.layout.simple_list_item_1, objects);
        grade1.setAdapter(adapter);
        grade2.setAdapter(adapter);
        grade3.setAdapter(adapter);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                float mymark = Float.parseFloat(c1.getText().toString());
                float mymark1 = Float.parseFloat(c2.getText().toString());
                float mymark2 = Float.parseFloat(c3.getText().toString());
                float mymark3 = Float.parseFloat(c4.getText().toString());

                String gradex = grade1.getSelectedItem().toString();
                String gradey = grade2.getSelectedItem().toString();
                String gradez = grade3.getSelectedItem().toString();

                if(mymark > 50)
                {
                    c1.setError("Marks has to be less than 50");
                }
                else if(mymark1 > 50)
                {
                    c2.setError("Marks has to be less than 50");
                }
                else if(mymark2 > 50)
                {
                    c3.setError("Marks has to be less than 50");
                }
                else if(mymark3 > 50)
                {
                    c4.setError("Marks has to be less than 50");
                }
                else
                {
                    float finalmarks1;
                    float finalmarks2;
                    float finalmarks3;
                    if(gradex.equals("A"))
                    {
                        finalmarks1 = 86;
                    }
                    else if(gradex.equals("A-"))
                    {
                        finalmarks1 = 82;
                    }
                    else if(gradex.equals("B+"))
                    {
                        finalmarks1 = 78;
                    }
                    else if(gradex.equals("B"))
                    {
                        finalmarks1 = 74;
                    }
                    else if(gradex.equals("B-"))
                    {
                        finalmarks1 = 70;
                    }
                    else if(gradex.equals("C+"))
                    {
                        finalmarks1 = 66;
                    }
                    else if(gradex.equals("C"))
                    {
                        finalmarks1 = 62;

                    }else if(gradex.equals("C-"))
                    {
                        finalmarks1 = 58;
                    }else if(gradex.equals("D+"))
                    {
                        finalmarks1 = 54;
                    }else
                    {
                        finalmarks1 = 50;
                    }

                    if(gradey.equals("A"))
                    {
                        finalmarks2 = 86;
                    }
                    else if(gradey.equals("A-"))
                    {
                        finalmarks2 = 82;
                    }
                    else if(gradey.equals("B+"))
                    {
                        finalmarks2 = 78;
                    }
                    else if(gradey.equals("B"))
                    {
                        finalmarks2 = 74;
                    }
                    else if(gradey.equals("B-"))
                    {
                        finalmarks2 = 70;
                    }
                    else if(gradey.equals("C+"))
                    {
                        finalmarks2 = 66;
                    }
                    else if(gradey.equals("C"))
                    {
                        finalmarks2 = 62;

                    }else if(gradey.equals("C-"))
                    {
                        finalmarks2 = 58;
                    }else if(gradey.equals("D+"))
                    {
                        finalmarks2 = 54;
                    }else
                    {
                        finalmarks2 = 50;
                    }


                    if(gradez.equals("A"))
                    {
                        finalmarks3 = 86;
                    }
                    else if(gradez.equals("A-"))
                    {
                        finalmarks3 = 82;
                    }
                    else if(gradez.equals("B+"))
                    {
                        finalmarks3 = 78;
                    }
                    else if(gradez.equals("B"))
                    {
                        finalmarks3 = 74;
                    }
                    else if(gradez.equals("B-"))
                    {
                        finalmarks3 = 70;
                    }
                    else if(gradez.equals("C+"))
                    {
                        finalmarks3 = 66;
                    }
                    else if(gradez.equals("C"))
                    {
                        finalmarks3 = 62;

                    }else if(gradez.equals("C-"))
                    {
                        finalmarks3 = 58;
                    }else if(gradez.equals("D+"))
                    {
                        finalmarks3 = 54;
                    }else
                    {
                        finalmarks3 = 50;
                    }


                    float factor1=finalmarks1/mymark;
                    System.out.println(""+factor1);
                    float factor2=finalmarks2/mymark1;
                    System.out.println(""+factor2);
                    float factor3=finalmarks3/mymark2;
                    System.out.println(""+factor3);


                    float avgfactor=factor1+factor2+factor3;
                    avgfactor=avgfactor/3;
                    System.out.println(""+avgfactor);
                    System.out.println(""+avgfactor);


                    float final4marks= avgfactor * mymark3;

                    if(final4marks > 86)
                    {
                        finalgrade.setText("A");
                    }
                    else if(final4marks > 82)
                    {
                        finalgrade.setText("A-");
                    }
                    else if(final4marks > 78)
                    {
                        finalgrade.setText("B+");
                    }
                    else if(final4marks > 74)
                    {
                        finalgrade.setText("B");
                    }
                    else if(final4marks > 70)
                    {
                        finalgrade.setText("B");
                    }
                    else if(final4marks > 66)
                    {
                        finalgrade.setText("C+");
                    }
                    else if(final4marks > 62)
                    {
                        finalgrade.setText("C");
                    }
                    else if(final4marks > 58)
                    {
                        finalgrade.setText("C-");
                    }
                    else if(final4marks > 54)
                    {
                        finalgrade.setText("D+");
                    }
                    else
                    {
                        finalgrade.setText("D");
                    }

                }




            }
        });


        return root;

    }
}
