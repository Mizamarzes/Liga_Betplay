package com.betplay.domain.entity;

public class Referee {
    private int id;
    private String name;
    private String country;
    private int experience;
    
    // Default constructor
    public Referee() {

    }

    // Constructor
    public Referee(int id, String name, String country, int experience) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.experience = experience;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    
}
