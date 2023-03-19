package com.digitalmedia.usersservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class User {

  @Id
  private String id;
  private String username;
  private String avatar;
  private String email;
  private String firstName;
  private String lastName;

  public User(String id, String username, String avatar, String email, String firstName, String lastName) {
    this.id = id;
    this.username = username;
    this.avatar= avatar;
    this.email= email;
    this.firstName= firstName;
    this.lastName= lastName;
  }

  public User(String username) {
    this.username = username;
  }
}
