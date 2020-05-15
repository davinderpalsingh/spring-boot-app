package com.davinder.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MobileAppWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}

	/*
	 * BCryptPasswordEncoder class that we are using comes from Spring Security Framework. We are using this class
	 * to encrypt the password supplied in the POST call before storing it in database.
	 * 
	 * We use @Bean annotation so that we can auto wire it into our User Service. 
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
