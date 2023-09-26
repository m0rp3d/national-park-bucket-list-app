package com.nationalparkbucketlist.backend.parkservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ParkServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkServicesApplication.class, args);
	}

}
