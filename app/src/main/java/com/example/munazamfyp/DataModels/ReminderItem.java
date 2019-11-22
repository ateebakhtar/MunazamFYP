package com.example.munazamfyp.DataModels;

public class ReminderItem
{
    public String date;
    public String time;
    public String typw;
    public String coursename;
    public String id;

    public ReminderItem()
    {

    }
    public void put(String date,String time, String type, String coursename, String usrid)
    {
        this.date = date;
        this.time = time;
        this.typw = type;
        this.coursename = coursename;
        id = usrid;
    }


    private int mImageResource;
    //private String coursename;
    //private String date;

    public ReminderItem(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        coursename = text1;
        date = text2;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return coursename;
    }

    public String getText2() {
        return date;
    }

}
