package com.babatunde;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoDemoApplication.class, args);
	}

//	@Autowired
//	private UserRepository userRepo;

	@PostConstruct
	public void initUsers() {
		/*
		 * User u1 = new User("Babatunde"); User u2 = new User("Lawal");
		 * userRepo.saveAll(Arrays.asList(u1, u2));
		 */
	}

}
