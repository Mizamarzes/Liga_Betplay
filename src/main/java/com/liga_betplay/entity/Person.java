package com.liga_betplay.entity;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String nationality;

    // Default constructor
    public Person() {

    }

    // Constructor
    public Person(int id, String name, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
