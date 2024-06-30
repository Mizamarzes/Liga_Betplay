package com.entity;

import java.util.List;

public class Player extends Person {
    private String position;
    private int shirt_number;
    private Team team;
    private List<Injury> injuries;
    private List<Performance> performances;

    // Default constructor
    public Player(){
        super();
    }

    // Constructors
    public Player(String position, int shirt_number, Team team, List<Injury> injuries, List<Performance> performances) {
        this.position = position;
        this.shirt_number = shirt_number;
        this.team = team;
        this.injuries = injuries;
        this.performances = performances;
    }

    public Player(int id, String name, int age, String nationality, String position, int shirt_number, Team team,
            List<Injury> injuries, List<Performance> performances) {
        super(id, name, age, nationality);
        this.position = position;
        this.shirt_number = shirt_number;
        this.team = team;
        this.injuries = injuries;
        this.performances = performances;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public List<Injury> getInjuries() {
        return injuries;
    }

    public void setInjuries(List<Injury> injuries) {
        this.injuries = injuries;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }
    
}
