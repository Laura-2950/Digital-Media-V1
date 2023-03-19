package com.msbills.models;

public class User {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;


    public User(String id, String username, String firstName, String lastName, String email) {
        this.id= id;
        this.username= username;
        this.firstName= firstName;
        this.lastName= lastName;
        this.email= email;
    }

    public User(String username, String firstName, String lastName, String email) {
        this.username= username;
        this.firstName= firstName;
        this.lastName= lastName;
        this.email= email;
    }

    public User() {
        //No-args constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "UserKeycloak{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
