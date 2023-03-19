package com.digitalmedia.usersservice.repository;

import com.digitalmedia.usersservice.exceptions.UserExtraNotFoundException;
import com.digitalmedia.usersservice.model.User;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongoUserRepository implements IUserRepository {
    private IMongoUserRepository mongoUserRepository;

    @Autowired
    public MongoUserRepository(IMongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }

    @Override
    public User validateAndGetUser(String username) {
        return getUserExtra(username).orElseThrow(() -> new UserExtraNotFoundException(username));
    }

    @Override
    public Optional<User> getUserExtra(String username) {
        return mongoUserRepository.findById(username);
    }

    @Override
    public User saveUserExtra(User user) {
        return mongoUserRepository.save(user);
    }

    public User saveUserKeycloak(UserRepresentation userRepresentation) {
        String nationality= "undefined";
        try {
            nationality= userRepresentation.getAttributes().get("nacionalidad").get(0);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user= new User(userRepresentation.getId(), userRepresentation.getUsername(), nationality, userRepresentation.getEmail(), userRepresentation.getFirstName(), userRepresentation.getLastName());
        return mongoUserRepository.save(user);
    }
}