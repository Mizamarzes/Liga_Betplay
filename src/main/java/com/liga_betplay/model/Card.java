package com.liga_betplay.model;

public class Card {
    private int id;
    private Player player;
    private Match match;
    private String type;
    private int minute;

    // Default constructor
    public Card(){

    }

    // Constructor
    public Card(int id, Player player, Match match, String type, int minute) {
        this.id = id;
        this.player = player;
        this.match = match;
        this.type = type;
        this.minute = minute;
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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}
