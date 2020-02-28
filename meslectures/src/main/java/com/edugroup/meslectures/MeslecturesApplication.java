package com.edugroup.meslectures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MeslecturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeslecturesApplication.class, args);
	}

}
