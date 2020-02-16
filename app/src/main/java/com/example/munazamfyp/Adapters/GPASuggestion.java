package com.example.munazamfyp.Adapters;


import java.text.DecimalFormat;

public class GPASuggestion{

        //This variable is used to get gpa correct to two decimal figures//

        private static DecimalFormat df = new DecimalFormat("0.00");

        //This function is used to suggest the gpa//
        public double[] suggest(double expected, double[] gpa, double[] credit,double cgpa) {
            //dummy hardcoded course gpa values along with thier respcetive credit hour in gpa//


            //double[] gpa = {1, 3, 4, 3.67, 2.67, 2.67, 3.33};
            //double[] credit = {1, 3, 3, 3, 1, 3, 3};

            double min = 10;
            int index = 0;
            //variable to find min//

            //double cgpa = 3.16;
            //this is a hardcoded gpa which would be get directly from database inn spring//
            int semester = 3;
            //this is a hardcoded semester which would be get directly from database inn spring//



            //a would be used to create and object so that we can calculate the gpa of  each semester individually//
            double[] gpa_to_improve;

            while (cgpa < expected) {

                for (int i = 0; i < gpa.length; i++) {
                    if (gpa[i] < min) {
                        min = gpa[i];
                        System.out.print(gpa[i]);
                        index = i;
                    }
                }
                gpa[index] = gpa[index] + 0.67;
                cgpa = calculate(gpa, credit);
                min = 10;


            }
            return gpa;
        }

        public double calculate(double gpa[], double credit[]) {
            double result = 0;
            double denominator = 0;
            double numerator = 0;
            for (int i = 0; i < gpa.length; i++) {
                denominator = (gpa[i] * credit[i]) + denominator;
                numerator = credit[i] + numerator;

            }
            result = denominator / numerator;
            return result;
        }
    }