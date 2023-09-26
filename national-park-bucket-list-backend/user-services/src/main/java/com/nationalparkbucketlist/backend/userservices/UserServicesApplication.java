package com.nationalparkbucketlist.backend.userservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServicesApplication.class, args);
	}

}
