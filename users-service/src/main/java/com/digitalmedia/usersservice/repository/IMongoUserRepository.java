package com.digitalmedia.usersservice.repository;

import com.digitalmedia.usersservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoUserRepository extends MongoRepository<User,String> {
}


