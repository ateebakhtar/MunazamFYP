package com.example.munazamfyp.DataModels;

public class date
{
    public static int day;
    public static int month;
    public static int year;

    public void input(int d,int m,int y)
    {
        day = d;
        month = m+1;
        year = y;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
