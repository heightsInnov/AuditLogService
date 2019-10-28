package com.jumia.pay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.mongodb.MongoClient;

@Configuration
public class BeanConfigs {

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(8);
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	public MongoClient mongoClient() {
		return new MongoClient("localhost", 27017);
	}

}
