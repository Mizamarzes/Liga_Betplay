package com.liga_betplay.model;

public class Trainer extends Person {
    private Team team;

    // Default Constructor
    public Trainer() {
        super();
    }

    // Constructors
    public Trainer(Team team) {
        this.team = team;
    }

    public Trainer(int id, String name, int age, String nationality, Team team) {
        super(id, name, age, nationality);
        this.team = team;
    }

    // Getters and Setters
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
}
