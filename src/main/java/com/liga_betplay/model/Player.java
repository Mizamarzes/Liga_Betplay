package com.liga_betplay.model;

public class Player extends Person {
    private String position;
    private int shirt_number;
    private Team team;

    // Default constructor
    public Player(){
        super();
    }

    // Constructors
    public Player(String position, int shirt_number, Team team) {
        this.position = position;
        this.shirt_number = shirt_number;
        this.team = team;
    }

    public Player(int id, String name, int age, String nationality, String position, int shirt_number, Team team) {
        super(id, name, age, nationality);
        this.position = position;
        this.shirt_number = shirt_number;
        this.team = team;
    }

    // Getters and Setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirt_number() {
        return shirt_number;
    }

    public void setShirt_number(int shirt_number) {
        this.shirt_number = shirt_number;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
