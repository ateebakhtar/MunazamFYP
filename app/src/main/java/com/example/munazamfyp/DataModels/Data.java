package com.example.munazamfyp.DataModels;

import android.text.StaticLayout;

import java.util.ArrayList;

public class Data
{
    public static String code;
    //holds the primary key id of the user
    public static String status = "notok";

    public static int user = 1;
    //valid login or not
    public static String validid = "notok";
    //for the edit of reminder screen
    public static String RID = null;
    //arraylist from reminder
    public static ArrayList<ReminderModel> x;
    //arraylist from workload
    public static ArrayList<Workload> y;
}
