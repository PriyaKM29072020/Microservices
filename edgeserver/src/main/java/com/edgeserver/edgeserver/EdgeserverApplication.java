package com.edgeserver.edgeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class EdgeserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeserverApplication.class, args);
	}

}
