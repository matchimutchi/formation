package com.edugroup.discoveryserverCircuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiscoveryserverCircuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryserverCircuitApplication.class, args);
	}

}
