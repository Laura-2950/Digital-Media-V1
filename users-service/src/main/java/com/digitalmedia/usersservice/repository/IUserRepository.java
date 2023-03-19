package com.digitalmedia.usersservice.repository;

import com.digitalmedia.usersservice.model.User;

import java.util.Optional;

public interface IUserRepository {

  User validateAndGetUser(String username);

  Optional<User> getUserExtra(String username);

  User saveUserExtra(User userExtra);
}
