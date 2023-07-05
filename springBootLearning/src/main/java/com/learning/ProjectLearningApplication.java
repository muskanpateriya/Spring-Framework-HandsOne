package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//main
@SpringBootApplication
@EnableDiscoveryClient
public class ProjectLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectLearningApplication.class, args);
	}

}
