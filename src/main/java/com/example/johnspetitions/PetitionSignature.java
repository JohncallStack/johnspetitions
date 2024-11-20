package com.example.johnspetitions;

//Class to create petition signature object so user can sign petitions.

public class PetitionSignature {
    private String name;
    private String email;

    public PetitionSignature (String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
