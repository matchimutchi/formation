package com.edugroup.trajetinfos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrajetinfosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrajetinfosApplication.class, args);
	}

}
