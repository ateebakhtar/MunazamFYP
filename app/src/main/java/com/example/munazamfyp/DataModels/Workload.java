package com.example.munazamfyp.DataModels;

public class Workload
{
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayleft() {
        return dayleft;
    }

    public void setDayleft(String dayleft) {
        this.dayleft = dayleft;
    }

    String day;
    String dayleft;
    String type;
    String course;
    public Workload()
    {

    }

    public void insert(String date, String type, String course, String dayl) {
        this.day = date;
        this.type = type;
        course = course;
        this.dayleft = dayl;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        course = course;
    }

}
