package com.babatunde;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.babatunde.model.CustomClient;
import com.babatunde.model.Role;
import com.babatunde.model.User;
import com.babatunde.repository.ClientRepository;
import com.babatunde.repository.RoleRepository;
import com.babatunde.repository.UserRepository;

@SpringBootApplication
public class SpringbootMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoDemoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private PasswordEncoder encoder;

	@PostConstruct
	public void initUsers() {
		Role r1 = null, r2 = null, r3 = null;
		if (clientRepo.count() <= 0) {
			CustomClient client = new CustomClient(encoder.encode("test"), "read,write,view",
					"authorization_code,password,refresh_token", "ROLE_ADMIN,ROLE_USER,ROLE_SUPER_ADMIN", 5 * 60,
					5 * 60 * 60);
			clientRepo.save(client);
		}
		if (roleRepo.count() <= 0) {
			r1 = new Role("ROLE_ADMIN");
			r2 = new Role("ROLE_SUPER_ADMIN");
			r3 = new Role("ROLE_USER");
			roleRepo.saveAll(Arrays.asList(r1, r2, r3));
		}
		if (userRepo.count() <= 0) {
			User u1 = new User("Lawal Babatunde", Arrays.asList(r1), "babatunde", encoder.encode("test"));
			User u2 = new User("Cristiano Ronaldo", Arrays.asList(r2), "cristiano", encoder.encode("test"));
			User u3 = new User("Lionel Messi", Arrays.asList(r3), "lionel", encoder.encode("test"));
			userRepo.saveAll(Arrays.asList(u1, u2, u3));
		}
		/*
		 * User u1 = new User("Babaunde", roles, username, password) //User u2 = new
		 * User("Lawal"); userRepo.saveAll(Arrays.asList(u1, u2));
		 */
	}

}
