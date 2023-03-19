package com.digitalmedia.usersservice.service;

import com.digitalmedia.usersservice.model.User;
import com.digitalmedia.usersservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl (UserRepository userRepository){
    this.userRepository=userRepository;
  }


  @Override
  public User validateAndGetUserExtra(String username) {
    return userRepository.validateAndGetUser(username);
  }

  @Override
  public Optional<User> getUserExtra(String username) {
    return userRepository.getUserExtra(username);
  }

  @Override
  public User saveUserExtra(User user) {
    return userRepository.saveUserExtra(user);
  }
}
