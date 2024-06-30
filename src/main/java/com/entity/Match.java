package com.entity;

import java.sql.Date;
import java.util.List;

public class Match {
    private int id;
    private Team localTeam;
    private Team visitTeam;
    private Date date;
    private String time;
    private Stadium stadium;
    private List<Goal> goals;
    private List<Card> cards;
    private List<Incident> incidents;
    private Result result;

    // default constructor
    public Match(){

    }

    // Constructor
    public Match(int id, Team localTeam, Team visitTeam, Date date, String time, Stadium stadium, List<Goal> goals,
            List<Card> cards, List<Incident> incidents, Result result) {
        this.id = id;
        this.localTeam = localTeam;
        this.visitTeam = visitTeam;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
        this.goals = goals;
        this.cards = cards;
        this.incidents = incidents;
        this.result = result;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(Team localTeam) {
        this.localTeam = localTeam;
    }

    public Team getVisitTeam() {
        return visitTeam;
    }

    public void setVisitTeam(Team visitTeam) {
        this.visitTeam = visitTeam;
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

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    
}
