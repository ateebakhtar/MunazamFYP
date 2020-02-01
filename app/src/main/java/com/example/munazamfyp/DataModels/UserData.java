package com.example.munazamfyp.DataModels;

public class UserData
{
    public static String name = null;
    String ID;
    public static String password;

    public static String getSemester() {
        return semester;
    }

    public static void setSemester(String semester) {
        UserData.semester = semester;
    }

    public static String semester;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
