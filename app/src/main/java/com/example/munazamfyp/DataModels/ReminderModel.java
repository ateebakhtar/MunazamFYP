package com.example.munazamfyp.DataModels;

public class ReminderModel
{
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String coursename;
    String date;
    String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;
    public ReminderModel()
    {

    }
    public ReminderModel(String c,String d, String t,String id)
    {
        coursename = c;
        date = d;
        type = t;
        this.id = id;
    }
}
