package com.digitalmedia.usersservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalmedia.usersservice.model.UserKeycloak;
import com.digitalmedia.usersservice.model.dto.UserKeycloakDto;
import com.digitalmedia.usersservice.repository.IUserKeycloakRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserKeycloakService {
    
    private IUserKeycloakRepository repositoryKeycloak;
    private ObjectMapper mapper;

    @Autowired
    public UserKeycloakService(IUserKeycloakRepository repositoryKeycloak, ObjectMapper mapper){
        this.repositoryKeycloak= repositoryKeycloak;
        this.mapper= mapper;
    }

    public List<UserKeycloakDto> findByFirstName(String firstName){
        List <UserKeycloak> users= repositoryKeycloak.findByFirstName(firstName);
        List <UserKeycloakDto> res= users.stream().map(user -> mapper.convertValue(user, UserKeycloakDto.class)).toList();
        return res;
    }

    public List<UserKeycloakDto> findByUsername(String username){
        List <UserKeycloak> users= repositoryKeycloak.findByUsername(username);
        List <UserKeycloakDto> res= users.stream().map(user -> mapper.convertValue(user, UserKeycloakDto.class)).toList();
        return res;
    }

    public UserKeycloakDto findById(String id){
        UserKeycloak users= repositoryKeycloak.findById(id);
        return mapper.convertValue(users, UserKeycloakDto.class);
    }

    public UserKeycloakDto updateNationality(String id, String nationality){
        UserKeycloak users= repositoryKeycloak.updateNationality(id, nationality);
        return mapper.convertValue(users, UserKeycloakDto.class);
    }

    public List<UserKeycloakDto> findNoAdmin(){
        List <UserKeycloak> users=repositoryKeycloak.findNoAdmin();
        List <UserKeycloakDto> res= users.stream().map(user -> mapper.convertValue(user, UserKeycloakDto.class)).toList();
        return res;
      }
}
