package com.digitalmedia.usersservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users_keycloak")
public class UserKeycloak {
    @Id
    private String id;
    private String username;
    private String email;
    private String firstName;
    private List<String> groups;
    private String nationality;

    public UserKeycloak(String id, String username, String email, String firstName, List<String> groups) {
        this.id= id;
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups= groups;
    }

    public UserKeycloak(String id, String username, String email, String firstName, List<String> groups, String nationality) {
        this.id= id;
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups= groups;
        this.nationality= nationality;
    }

    public UserKeycloak(String username, String email, String firstName, List<String> groups) {
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups=groups;
    }

    public UserKeycloak(String username, String email, String firstName, List<String> groups, String nationality) {
        this.username= username;
        this.email= email;
        this.firstName= firstName;
        this.groups=groups;
        this.nationality= nationality;
    }

    public UserKeycloak() {
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

    @java.lang.Override
    public java.lang.String toString() {
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
