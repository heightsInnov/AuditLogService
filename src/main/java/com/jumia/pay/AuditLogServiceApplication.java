package com.jumia.pay;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jumia.pay.model.BasicClientDetails;
import com.jumia.pay.repository.ClientDetailsRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class AuditLogServiceApplication {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private ClientDetailsRepository clientRepo;

	public static void main(String[] args) {
		SpringApplication.run(AuditLogServiceApplication.class, args);
	}
	
	@PostConstruct
	public void initializeClients() {
		BasicClientDetails client = new BasicClientDetails("test", encoder.encode("test"), "password,refresh_token","ROLE_USER,ROLE_ADMIN,ROLE_SUPER_ADMIN","read,write,view_status","",5*60, 3*60*60);
		clientRepo.save(client);
	}

}
