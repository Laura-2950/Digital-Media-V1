package com.digitalmedia.usersservice.controller;

import com.digitalmedia.usersservice.model.User;
import com.digitalmedia.usersservice.model.dto.UserKeycloakDto;
import com.digitalmedia.usersservice.model.dto.UserRequest;
import com.digitalmedia.usersservice.service.IUserService;
import com.digitalmedia.usersservice.service.UserKeycloakService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {


  private final IUserService userService;
  private UserKeycloakService userKeycloakService;

  @Autowired
  public UserController(IUserService userService, UserKeycloakService userKeycloakService){
    this.userService= userService;
    this.userKeycloakService= userKeycloakService;
  }

 //TODO  estos dos endpoints funcionaran cuando este configurada la seguridad en el proyecto

  @GetMapping("/me")
  public User getUserExtra(Principal principal) {
    return userService.validateAndGetUserExtra(principal.getName());
  }


  /*@GetMapping("/me")
  public User getUserExtra(@RequestParam String principal) {
    return userService.validateAndGetUserExtra(principal);
  }*/

  @PostMapping("/me")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public User saveUserExtra(@Valid @RequestBody UserRequest updateUserRequest, @RequestParam(value = "principal") String principal) {
    Optional<User> userOptional = userService.getUserExtra(principal);
    User userExtra = userOptional.orElseGet(() -> new User(principal));
    userExtra.setAvatar(updateUserRequest.getAvatar());
    return userService.saveUserExtra(userExtra);
  }
  

  @GetMapping("/keycloak/{firstName}")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public List<UserKeycloakDto> findByFirstName(@PathVariable String firstName){
    return userKeycloakService.findByFirstName(firstName);
  }

  @GetMapping("/find/{username}")
  @PreAuthorize("hasAuthority('GROUP_admin') OR hasAuthority('GROUP_provider') OR hasAuthority('GROUP_client')")
  public List<UserKeycloakDto> findByUsername(@PathVariable String username){
    return userKeycloakService.findByFirstName(username);
  }

  @GetMapping("/keycloak/id/{id}")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public UserKeycloakDto findById(@PathVariable String id){
    return userKeycloakService.findById(id);
  }

  @GetMapping("/keycloak/{id}/{nationality}")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public UserKeycloakDto updateNationality(@PathVariable String id, @PathVariable String nationality){
    return userKeycloakService.updateNationality(id, nationality);
  }

  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public List<UserKeycloakDto> getUsersNoAdmin() {
    return userKeycloakService.findNoAdmin();
  }

}
