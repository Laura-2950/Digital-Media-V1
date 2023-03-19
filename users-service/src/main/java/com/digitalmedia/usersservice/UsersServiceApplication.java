package com.digitalmedia.usersservice;

import java.util.Arrays;
import java.util.List;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.digitalmedia.usersservice.repository.MongoUserRepository;


@SpringBootApplication
@EnableEurekaClient
public class UsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
				
	}


	@Bean
	CommandLineRunner runner(Keycloak keycloakClient, MongoUserRepository mongoUserRepository){
		return args ->{
			
            if(keycloakClient.realm("DigitalMedia").users().count() <= 3){
				CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
				credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
				credentialRepresentation.setValue("admin");
		
				UserRepresentation userRepresentation = new UserRepresentation();
				userRepresentation.setUsername("admin");
				userRepresentation.setFirstName("admin");
				userRepresentation.setLastName("admin");
				userRepresentation.setEnabled(true);
				userRepresentation.setGroups(List.of("admin"));
				userRepresentation.setEmail("admin@gmail.com");		
				userRepresentation.setCredentials(Arrays.asList(credentialRepresentation));
				keycloakClient.realm("DigitalMedia").users().create(userRepresentation);
				List<UserRepresentation> res =keycloakClient.realm("DigitalMedia").users().search(userRepresentation.getUsername());
				mongoUserRepository.saveUserKeycloak(res.get(0));

				CredentialRepresentation credentialRepresentation1 = new CredentialRepresentation();
				credentialRepresentation1.setType(CredentialRepresentation.PASSWORD);
				credentialRepresentation1.setValue("client");
		
				UserRepresentation userRepresentation1 = new UserRepresentation();
				userRepresentation1.setUsername("client");
				userRepresentation1.setFirstName("client");
				userRepresentation1.setLastName("client");
				userRepresentation1.setEnabled(true);
				userRepresentation1.setGroups(List.of("client"));
				userRepresentation1.setEmail("client@gmail.com");		
				userRepresentation1.setCredentials(Arrays.asList(credentialRepresentation1));
				keycloakClient.realm("DigitalMedia").users().create(userRepresentation1);
				List<UserRepresentation> res1 =keycloakClient.realm("DigitalMedia").users().search(userRepresentation1.getUsername());
				mongoUserRepository.saveUserKeycloak(res1.get(0));

				CredentialRepresentation credentialRepresentation2 = new CredentialRepresentation();
				credentialRepresentation2.setType(CredentialRepresentation.PASSWORD);
				credentialRepresentation2.setValue("provider");
		
				UserRepresentation userRepresentation2 = new UserRepresentation();
				userRepresentation2.setUsername("provider");
				userRepresentation2.setFirstName("provider");
				userRepresentation2.setLastName("provider");
				userRepresentation2.setEnabled(true);
				userRepresentation2.setGroups(List.of("provider"));
				userRepresentation2.setEmail("provider@gmail.com");		
				userRepresentation2.setCredentials(Arrays.asList(credentialRepresentation2));
				keycloakClient.realm("DigitalMedia").users().create(userRepresentation2);
				List<UserRepresentation> res2 =keycloakClient.realm("DigitalMedia").users().search(userRepresentation2.getUsername());
				mongoUserRepository.saveUserKeycloak(res2.get(0));

			};
    	};
	}
}
