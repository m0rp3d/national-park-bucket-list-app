package com.nationalparkbucketlist.backend.userservices;

import com.nationalparkbucketlist.backend.userservices.controller.UserController;
import com.nationalparkbucketlist.backend.userservices.dao.UserRepository;
import com.nationalparkbucketlist.backend.userservices.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class UserServicesApplication {
	@Autowired
	private UserController userController;

	public static void main(String[] args) {

		SpringApplication.run(UserServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository repository) {

		return args -> {
			User user = new User("second",
					"second",
					"second2@gmail.com"
			);

			repository.findUserByEmail(user.getEmail())
							.ifPresentOrElse(u -> {
								System.out.println(user + " user already exist");
							}, () -> {
								System.out.println("Inserting user " + user);
								userController.createUser(user);
							});

		};
	}

}
