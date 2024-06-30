package com.liga_betplay.model;

public class Role {
    private int id;
    private String name;
    private int permission;

    // Default constructor
    public Role(){

    }
    
    public Role(int id, String name, int permission) {
        this.id = id;
        this.name = name;
        this.permission = permission;
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

    public int getPermissions() {
        return permission;
    }

    public void setPermissions(int permission) {
        this.permission = permission;
    }

}

