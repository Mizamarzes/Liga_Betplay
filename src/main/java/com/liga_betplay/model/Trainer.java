package com.liga_betplay.model;

public class Trainer extends Person {

    private int experience;

    // Constructor sin id
    public Trainer(String name, int age, String nationality, int experience) {
        super(name, age, nationality);
        this.experience = experience;
    }

    // Constructor con id
    public Trainer(int id, String name, int age, String nationality, int experience) {
        super(id, name, age, nationality);
        this.experience = experience;
    }

    // Getters y Setters
    public int getExperience() {
        return experience;
    }

    public int gerId(){
        return id;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setCountry(String nationality) {
        this.nationality = nationality;
    }

}

