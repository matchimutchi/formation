package com.edugroup.villeinfos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VilleinfosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VilleinfosApplication.class, args);
	}

}
