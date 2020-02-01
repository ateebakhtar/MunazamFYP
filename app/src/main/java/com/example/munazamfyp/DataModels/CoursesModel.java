package com.example.munazamfyp.DataModels;

public class CoursesModel
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public CoursesModel(String name, String section) {
        this.name = name;
        this.section = section;
    }

    String name;
    String section;
}
