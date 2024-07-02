package com.liga_betplay.model;

public class Team {
    private int id;
    private String name;
    private String city;
    private Stadium stadium;
    private Trainer trainer;
    private League league;

    // default constructor
    public Team(){

    }

    // contructor
    public Team(int id, String name, String city, Stadium stadium, Trainer trainer, League league) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.stadium = stadium;
        this.trainer = trainer;
        this.league = league;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
