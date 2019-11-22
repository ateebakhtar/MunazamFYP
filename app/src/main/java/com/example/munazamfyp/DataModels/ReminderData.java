package com.example.munazamfyp.DataModels;

public class ReminderData
{
    static String topic;
    static String course;

    public static String getCourse() {
        return course;
    }

    public static void setCourse(String course) {
        ReminderData.course = course;
    }

    public static String getTopic() {
        return topic;
    }

    public static void setTopic(String topic) {
        ReminderData.topic = topic;
    }
}
