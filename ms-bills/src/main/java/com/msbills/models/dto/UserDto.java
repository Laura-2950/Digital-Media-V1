package com.msbills.models.dto;

public class UserDto {
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public UserDto(String username, String firstName, String lastName, String email) {
        this.username= username;
        this.firstName= firstName;
        this.lastName= lastName;
        this.email= email;
    }

    public UserDto() {
        //No-args constructor
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
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
