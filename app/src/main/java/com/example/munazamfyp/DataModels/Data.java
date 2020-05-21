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
    //semester
    public static String semester = "1";
    //the selected course list
    public static ArrayList<CourseModel> courses = new ArrayList<CourseModel>();
    //list of course names and section
    public static ArrayList<CoursesModel> x1 = new ArrayList<CoursesModel>();
    //ip address of the server
    public final static String ip = "http://192.168.100.14:808/";
    //public final static String ip = "http://192.168.100.14:8080/";
    // list of attendees
    public static ArrayList<AttendeesModel> m;
    //list of meetings
    public static ArrayList<MeetingModel> meetingModels = new ArrayList<MeetingModel>();
    //list of my joined meeting list
    public static ArrayList<MeetingModel> joinedmeeting = new ArrayList<MeetingModel>();
    //list of my meetings
    public static ArrayList<MeetingModel> mymeetings = new ArrayList<MeetingModel>();
    //enter meeting object
    public static MeetingModel mobj = new MeetingModel();
    //network status
    public static String networkstatus = "ok";
    //dialog box for instructions
    public static int showdialog = 1;
    //for notification of and on
    public static int noficationstatus = 0;

}
