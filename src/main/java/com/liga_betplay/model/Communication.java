package com.liga_betplay.model;

import java.sql.Date;
import java.util.List;

public class Communication {
    private int id;
    private String title;
    private String content;
    private Date publicationDate;
    private List<User> recipients;

    // Default constructor
    public Communication(){

    }

    // Constructor
    public Communication(int id, String title, String content, Date publicationDate, List<User> recipients) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.recipients = recipients;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }
}
