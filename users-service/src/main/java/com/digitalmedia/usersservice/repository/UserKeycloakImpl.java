package com.digitalmedia.usersservice.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.digitalmedia.usersservice.model.UserKeycloak;

@Repository //Todo hay q ver si deja tener dos repositorios, de lo contrario hay q hacer una instancia de este en el repositorio de mongo
public class UserKeycloakImpl implements IUserKeycloakRepository{
    
    @Autowired
    private Keycloak keycloakClient;

    @Value("${digitalMedia.keycloak.realm}")
    private String realm;

    @Override
    public List<UserKeycloak> findByFirstName(String firstName){
        List<UserRepresentation> users= keycloakClient.realm(realm).users().search(firstName);
        return users.stream().map(userRepresentation -> toUserKeycloak(userRepresentation)).collect(Collectors.toList());
    }

    @Override
    public UserKeycloak findById(String id){
        UserRepresentation users= keycloakClient.realm(realm).users().get(id).toRepresentation();
        return toUserKeycloak(users);
    }

    @Override
    public UserKeycloak updateNationality(String id, String nationality){
        UserResource userResource= keycloakClient.realm(realm).users().get(id);
        UserRepresentation userRepresentation= userResource.toRepresentation();
        Map<String, List<String>> attributes= new HashMap<>();
        attributes.put("nacionalidad", List.of(nationality));
        userRepresentation.setAttributes(attributes);
        userResource.update(userRepresentation);
        return  toUserKeycloak(userRepresentation);
    }

    @Override
    public List<UserKeycloak> findNoAdmin(){

        List<GroupRepresentation> groupRepresentations = keycloakClient
                .realm(realm)
                .groups()
                .groups();

        List<UserRepresentation> allUserRepresentations = new ArrayList<>();
        List<UserRepresentation> adminUserRepresentations = new ArrayList<>();

        allUserRepresentations=keycloakClient
                .realm(realm)
                .users()
                .list();

        for(GroupRepresentation g: groupRepresentations) {
            if (g.getName().contains("admin"))
            {adminUserRepresentations=keycloakClient.realm(realm)
                    .groups()
                    .group(g.getId())
                    .members();
                break;
            }
        }

        List<UserRepresentation> finalUser = allUserRepresentations;

        for(int f=0; f<allUserRepresentations.size();f++)
            for(int i=0;i<adminUserRepresentations.size();i++)
                if(allUserRepresentations.get(f).getId().contains(adminUserRepresentations.get(i).getId()))
                    finalUser.remove(f);


        List<UserKeycloak> userList = finalUser.stream().map(this::toUserKeycloak).collect(Collectors.toList());

        return userList;
    }

    @Override
    public List<UserKeycloak> findByUsername(String username) {
        List<UserRepresentation> users= keycloakClient.realm(realm).users().search(username);
        return users.stream().map(userRepresentation -> toUserKeycloak(userRepresentation)).collect(Collectors.toList());
    }

    public UserKeycloak toUserKeycloak(UserRepresentation userRepresentation){

        String nationality= null;
        try {
            nationality= userRepresentation.getAttributes().get("nacionalidad").get(0);            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new UserKeycloak(userRepresentation.getId(), userRepresentation.getUsername(), userRepresentation.getEmail(), userRepresentation.getFirstName(), userRepresentation.getGroups(), nationality); //.group(userRepresentation.getId()).members().collect(Collectors.toList()  .stream().map(group -> group.getName()).collect(Collectors.toList())
    }



}
