package com.example.munazamfyp.DataModels;

public class Workload
{

    String day;
    String dayleft;
    String type;
    String course;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Workload()
    {

    }
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
    public void insert(String date, String type, String course, String dayl,String id) {
        this.day = date;
        this.type = type;
        this.course = course;
        this.dayleft = dayl;
        this.id = id;
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
        this.course = course;
    }

}
