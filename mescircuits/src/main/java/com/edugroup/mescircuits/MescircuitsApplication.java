package com.edugroup.mescircuits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MescircuitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MescircuitsApplication.class, args);
	}

}
