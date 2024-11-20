package com.example.johnspetitions;
import java.util.UUID;

//Class to create petition object that will hold required data to create a new petition on web app.

public class Petition {
    private String id;
    private String title;
    private String oneLine;
    private String description;
    private String creatorName;
    private boolean subscriberNewsletter;

    public Petition(String title, String oneLine, String description, String creatorName, boolean subscriberNewsletter){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.oneLine = oneLine;
        this.description = description;
        this.creatorName = creatorName;
        this.subscriberNewsletter = subscriberNewsletter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public boolean isSubscriberNewsletter() {
        return subscriberNewsletter;
    }

    public void setSubscriberNewsletter(boolean subscriberNewsletter) {
        this.subscriberNewsletter = subscriberNewsletter;
    }

    public String getOneLine() {
        return oneLine;
    }

    public void setOneLine(String oneLine) {
        this.oneLine = oneLine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
} // end class
