package com.entity;

public class Activity {
    private int id;
    private String description;
    private int duration;

    // Default constructor
    public Activity(){

    }

    // Constructor
    public Activity(int id, String description, int duration) {
        this.id = id;
        this.description = description;
        this.duration = duration;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}
