package com.example.munazamfyp.DataModels;

public class time
{
    public static int hour;
    public static int min;
    public void input(int h,int m)
    {
        hour = h;
        min = m;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }
}
