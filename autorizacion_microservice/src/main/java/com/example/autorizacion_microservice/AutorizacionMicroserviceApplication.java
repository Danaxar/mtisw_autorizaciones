package com.example.autorizacion_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutorizacionMicroserviceApplication {

	public static void main(String[] args) {
		System.out.println("${spring.application.name}:${spring.application.instance_id:${random.value}}");
		SpringApplication.run(AutorizacionMicroserviceApplication.class, args);
		System.out.println("Running.");
		System.out.println("${spring.application.name}:${spring.application.instance_id:${random.value}}");
	}

}
