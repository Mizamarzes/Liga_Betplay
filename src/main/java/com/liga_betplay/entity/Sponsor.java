package com.liga_betplay.entity;

import java.sql.Date;

public class Sponsor {
    private int id;
    private String name;
    private String type;
    private Double ammount;
    private Date startDate;
    private Date endDate;

    // Default constructor
    public Sponsor(){

    }
    
    // Constructor
    public Sponsor(int id, String name, String type, Double ammount, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ammount = ammount;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
