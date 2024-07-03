package com.liga_betplay.model;

public class Trainer extends Person{

    private int experience;

    public Trainer() {
    }

    public Trainer(int id, String name, int age, String country, int experience) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = country;
        this.experience = experience;
    }

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

    public String getCountry() {
        return nationality;
    }

    public void setCountry(String country) {
        this.nationality = country;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    
    
}
