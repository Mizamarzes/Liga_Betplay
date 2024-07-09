package com.betplay.domain.entity;

public class Goal {
    private int id;
    private Player player;
    private Team team;
    private int minute;
    private Match match;

    // Default constructor
    public Goal(){

    }

    // Constructor
    public Goal(int id, Player player, Team team, int minute, Match match) {
        this.id = id;
        this.player = player;
        this.team = team;
        this.minute = minute;
        this.match = match;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getminute() {
        return minute;
    }

    public void setminute(int minute) {
        this.minute = minute;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
