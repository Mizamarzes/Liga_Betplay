package com.entity;

import java.sql.Date;

public class Transfer {
    private int id;
    private Player player;
    private Team sourceTeam;
    private Team destinationTeam;
    private Double amount;
    private Date date;

    // Default constructor
    public Transfer(){

    }

    // Constructor
    public Transfer(int id, Player player, Team sourceTeam, Team destinationTeam, Double amount, Date date) {
        this.id = id;
        this.player = player;
        this.sourceTeam = sourceTeam;
        this.destinationTeam = destinationTeam;
        this.amount = amount;
        this.date = date;
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

    public Team getSourceTeam() {
        return sourceTeam;
    }

    public void setSourceTeam(Team sourceTeam) {
        this.sourceTeam = sourceTeam;
    }

    public Team getDestinationTeam() {
        return destinationTeam;
    }

    public void setDestinationTeam(Team destinationTeam) {
        this.destinationTeam = destinationTeam;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
