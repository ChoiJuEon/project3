package com.kwangwoon.project3;

import com.kwangwoon.project3.model.User;
import com.kwangwoon.project3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Project3Application {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			if (userRepository.findByUsername("admin") == null) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("1234"));
				userRepository.save(admin);
			}
		};
	}
}
