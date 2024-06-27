package com.entity;

import java.sql.Date;

public class Ticket {
    private int id;
    private Match match;
    private User buyer;
    private Date purchaseDate;
    private int quantity;
    private double totalPrice;
    private String seatLocation;

    // Default constructor
    public Ticket(){

    }

    // Constructor
    public Ticket(int id, Match match, User buyer, Date purchaseDate, int quantity, double totalPrice,
            String seatLocation) {
        this.id = id;
        this.match = match;
        this.buyer = buyer;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.seatLocation = seatLocation;
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

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }
}
