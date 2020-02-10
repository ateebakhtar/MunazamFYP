package com.example.munazamfyp.DataModels;

public class extendeditem
{
    private String topic;
    private String time;
    private String date;
    private String capacity;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private boolean expanded;

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public extendeditem(String topic, String time, String date, String description, String capacity,String id) {
        this.topic = topic;
        this.time = time;
        this.date = date;
        this.description = description;
        this.capacity=capacity;
        this.expanded = false;
        this.id = id;

    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }



    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }



    @Override
    public String toString() {
        return "extendeditem{" +
                "topic='" + topic + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", expanded=" + expanded +
                '}';
    }
}
