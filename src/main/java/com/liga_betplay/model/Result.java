package com.liga_betplay.model;

public class Result {
    private int id;
    private Match match;
    private int goalsLocalTeam;
    private int goalsVisitTeam;

    // Default constructor
    public Result(){

    }

    // Constructor
    public Result(int id, Match match, int goalsLocalTeam, int goalsVisitTeam) {
        this.id = id;
        this.match = match;
        this.goalsLocalTeam = goalsLocalTeam;
        this.goalsVisitTeam = goalsVisitTeam;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getgoalsLocalTeam() {
        return goalsLocalTeam;
    }

    public void setgoalsLocalTeam(int goalsLocalTeam) {
        this.goalsLocalTeam = goalsLocalTeam;
    }

    public int getgoalsVisitTeam() {
        return goalsVisitTeam;
    }

    public void setgoalsVisitTeam(int goalsVisitTeam) {
        this.goalsVisitTeam = goalsVisitTeam;
    }

}
