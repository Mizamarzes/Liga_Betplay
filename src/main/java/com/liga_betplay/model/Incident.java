package com.liga_betplay.model;

public class Incident {
    private int id;
    private Match match;
    private String description;
    private int minute;

    // Default constructor
    public Incident(){

    }

    // Constructor
    public Incident(int id, Match match, String description, int minute) {
        this.id = id;
        this.match = match;
        this.description = description;
        this.minute = minute;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
