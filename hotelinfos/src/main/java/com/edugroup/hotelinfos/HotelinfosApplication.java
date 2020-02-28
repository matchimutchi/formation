package com.edugroup.hotelinfos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelinfosApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelinfosApplication.class, args);
	}

}
