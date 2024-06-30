package com.liga_betplay.model;

import java.sql.Date;

public class Injury {
    private int id;
    private Player player;
    private String type;
    private String severity;
    private Date startDate;
    private Date endDate;

    //Default constructor
    public Injury(){

    }

    // Constructor
    public Injury(int id, Player player, String type, String severity, Date startDate, Date endDate) {
        this.id = id;
        this.player = player;
        this.type = type;
        this.severity = severity;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
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
