package com.betplay.domain.entity;

public class Permission {
    private int id;
    private String description;

    // Default consturctor
    public Permission(){

    }

    // Constructor
    public Permission(int id, String description) {
        this.id = id;
        this.description = description;
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
}
