package com.example.usermanagementsystemAPIgateway.model;

public class UserModel {

    private String firstName;
    private String lastName;
    private String dataCreated;
    private String emailAddress;

    public UserModel() {
    }

    public UserModel( String firstName, String lastName, String dataCreated, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataCreated = dataCreated;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(String dataCreated) {
        this.dataCreated = dataCreated;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}


