package com.digitalmedia.usersservice.service;

import com.digitalmedia.usersservice.model.User;

import java.util.Optional;

public interface IUserService {
  User validateAndGetUserExtra(String username);

  Optional<User> getUserExtra(String username);

  User saveUserExtra(User userExtra);

}
