package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.munazamfyp.Connections.GetSemester;
import com.example.munazamfyp.DataModels.CoursesModel;
import com.example.munazamfyp.DataModels.Data;

import java.util.ArrayList;

public class SelectCourses extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner1;
    Spinner spinner2;

    Spinner section;
    Spinner section1;
    Spinner section2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_courses);

        spinner = findViewById(R.id.spinner2a);
        spinner1 = findViewById(R.id.spinner3a);
        spinner2 = findViewById(R.id.spinner4a);

        section = findViewById(R.id.spinner2b);
        section1 = findViewById(R.id.spinner3b);
        section2 = findViewById(R.id.spinner4b);


        String sections[] =
                {
                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "GR1", "GR2", "GR3", "GR4"};

        String[] semester1 = {
                "English Composition and Comprehension",
                "English Composition and Comprehension  Lab",
                "Islamic and Religious Studies",
                "Programming Fundamentals",
                "Programming Fundamentals Lab",
                "Applied Physics",
                "Calculus Analytical Geometry"};


        String[] semester2 =
                {
                        "Computer Programming Lab",
                        "Computer Programming",
                        "Calculus - II",
                        "Digital Logic Design",
                        "English Composition",
                        "Pakistan Studies",
                        "Digital Logic Design - Lab"
                };

        String[] semester3 =
                {
                        "Data Structures",
                        "Comp. Organization and Assembly Lang. Lab",
                        "Business Communication - I",
                        "Comp. Organization and Assembly Lang",
                        "Discrete Structures",
                        "Linear Algebra"

                };
        String[] semester4 =
                {
                        "Organizational Behavior",
                        " Operating Systems Lab",
                        "Theory of Automata",
                        "Computing Methods - I",
                        "Probability and Statistics",
                        "Operating Systems",
                };

        String[] semester5 =
                {
                        "Communication for Managers",
                        " Database Systems",
                        "Object Oriented Analysis and Design Lab",
                        "Computer Architecture",
                        "Design and Analysis of Algorithms",
                        "Database Systems Lab",
                        "Object Oriented Analysis and Design",
                };

        String[] semester6 =
                {
                        "Technical and Business Writing",
                        "Data Science",
                        "Computer Networks Lab",
                        "Computer Networks",
                        "Software Engineering",
                        "Artificial Intelligence"
                };

        String[] semester7 =
                {
                        "Information Systems Security",
                        "Professional Issues in IT",
                        "Human Computer Interaction",
                        "Design Defects and Restructuring",
                        "Project - I",
                };

        String[] objects1 = null;
        if (Data.semester.equals("1")) {
            objects1 = semester1;
        } else if (Data.semester.equals("2")) {
            objects1 = semester2;
        } else if (Data.semester.equals("3")) {
            objects1 = semester3;
        } else if (Data.semester.equals("4")) {
            objects1 = semester4;
        } else if (Data.semester.equals("5")) {
            objects1 = semester5;
        } else if (Data.semester.equals("6")) {
            objects1 = semester6;
        } else {
            objects1 = semester7;
        }

        String[] section_data = sections;

        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, objects1);
        spinner.setAdapter(adapter1);
        ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, objects1);
        spinner1.setAdapter(adapter2);
        ArrayAdapter adapter3 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, objects1);
        spinner2.setAdapter(adapter3);

        ArrayAdapter adapter8 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, section_data);
        section.setAdapter(adapter8);
        ArrayAdapter adapter9 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, section_data);
        section1.setAdapter(adapter9);
        ArrayAdapter adapter10 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, section_data);
        section2.setAdapter(adapter10);
    }

    public void next(View view) {


        Data.x1 = new ArrayList<CoursesModel>();

        Data.x1.add(new CoursesModel(spinner.getSelectedItem().toString(), section.getSelectedItem().toString()));
        Data.x1.add(new CoursesModel(spinner1.getSelectedItem().toString(), section1.getSelectedItem().toString()));
        Data.x1.add(new CoursesModel(spinner2.getSelectedItem().toString(), section2.getSelectedItem().toString()));

        String a[] = new String[3];

        int count = 0;

        a[0] = Data.x1.get(0).getName();
        a[1] = Data.x1.get(1).getName();
        a[2] = Data.x1.get(2).getName();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i].equals(a[j])) {
                    count++;
                    System.out.println("dad" + count + "  " + a[i]);
                }
            }
        }


        if (count > 3) {

            Toast.makeText(getApplicationContext(), "work done", Toast.LENGTH_LONG).show();
            count = 0;
            //comdtion

        } else {
            count = 0;
            Intent i = new Intent(this, SelectCourses2.class);
            System.out.println("afagasbnasnba");
            startActivity(i);


            //Data.x.get(0).getName();

        }


    }
}
