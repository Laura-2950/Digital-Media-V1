package com.digitalmedia.usersservice.model.dto;

import java.util.List;

public class UserKeycloakDto {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private List<String> groups;
    private String nationality;

    public UserKeycloakDto(String id, String username, String email, String firstName, List<String> groups) {
        this.id= id;
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups= groups;
    }

    public UserKeycloakDto(String id, String username, String email, String firstName, List<String> groups, String nationality) {
        this.id= id;
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups= groups;
        this.nationality= nationality;
    }

    public UserKeycloakDto(String username, String email, String firstName, List<String> groups) {
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups=groups;
    }

    public UserKeycloakDto(String username, String email, String firstName, List<String> groups, String nationality) {
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups=groups;
        this.nationality= nationality;
    }

    public UserKeycloakDto() {
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

    public List<String>  getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public String  getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "UserKeycloak{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", groups=" + groups +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
