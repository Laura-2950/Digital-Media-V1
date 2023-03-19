package com.digitalmedia.usersservice.repository;

import java.util.List;

import com.digitalmedia.usersservice.model.UserKeycloak;

public interface IUserKeycloakRepository {
    
    public List<UserKeycloak> findByFirstName(String firstName);

    public UserKeycloak findById(String id);

    public UserKeycloak updateNationality(String id, String nationality);

    public List<UserKeycloak> findNoAdmin();

    public List<UserKeycloak> findByUsername(String username);
}
