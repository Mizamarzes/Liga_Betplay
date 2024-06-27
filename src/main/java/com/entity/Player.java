package com.entity;

import java.util.List;

public class Player {
    private int id;
    private String name;
    private int age;
    private String position;
    private String nationality;
    private int shirt_number;
    private String team;
    private List<Injury> injuries;
    private List<Performance> performances;

    // Default constructor
    public Player(){

    }

    // Constructor
    public Player(int id, String name, int age, String position, String nationality, int shirt_number, String team,
            List<Injury> injuries, List<Performance> performances) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
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
