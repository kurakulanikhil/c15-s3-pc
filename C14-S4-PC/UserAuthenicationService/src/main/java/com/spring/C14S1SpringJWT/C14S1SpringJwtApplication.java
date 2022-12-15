package com.spring.C14S1SpringJWT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class C14S1SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(C14S1SpringJwtApplication.class, args);
	}

}
