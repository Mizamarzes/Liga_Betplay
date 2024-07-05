package com.liga_betplay.model;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String nationality;

    // Constructor sin id
    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    // Constructor con id
    public Person(int id, String name, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    // Getters y Setters
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

