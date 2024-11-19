package com.example.johnspetitions;

public class Petition {
    private String title;
    private String description;
    private String creatorName;
    private boolean subscriberNewsletter;

    public Petition(String title, String description, String creatorName, boolean subscriberNewsletter){
        this.title = title;
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

} // end class
