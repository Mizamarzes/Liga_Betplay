package com.betplay.domain.entity;

import java.sql.Date;
import java.util.List;

public class Training {
    private int id;
    private Team team;
    private Date date;
    private String time;
    private String location;
    private List<Activity> activities;
    private List<Player> summonedPlayers;

    // Default constructor
    public Training(){

    }

    // Constructor
    public Training(int id, Team team, Date date, String time, String location, List<Activity> activities,
            List<Player> summonedPlayers) {
        this.id = id;
        this.team = team;
        this.date = date;
        this.time = time;
        this.location = location;
        this.activities = activities;
        this.summonedPlayers = summonedPlayers;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Player> getSummonedPlayers() {
        return summonedPlayers;
    }

    public void setSummonedPlayers(List<Player> summonedPlayers) {
        this.summonedPlayers = summonedPlayers;
    }
    
}
