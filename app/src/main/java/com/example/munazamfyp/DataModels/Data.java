package com.example.munazamfyp.DataModels;

import android.text.StaticLayout;

import java.util.ArrayList;

public class Data
{
    public static String code;
    //holds the primary key id of the user
    public static String status = "1";

    public static int user = 1;
    //valid login or not
    public static String validid = "notok";
    //for the edit of reminder screen
    public static String RID = null;
    //arraylist from reminder
    public static ArrayList<ReminderModel> x;
    //arraylist from workload
    public static ArrayList<Workload> y;
    //semester
    public static String semester = "1";
    //the selected course list
    public static ArrayList<CourseModel> courses = new ArrayList<CourseModel>();
    //list of course names and section
    public static ArrayList<CoursesModel> x1 = new ArrayList<CoursesModel>();
    //ip address of the server
    public final static String ip = "http://192.168.100.14:8080/";
}
