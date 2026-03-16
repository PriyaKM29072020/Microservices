package com.edgeserver.edgeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EdgeserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeserverApplication.class, args);
	}

@Bean
@LoadBalanced
public RestTemplate loadBalancedWebClientBuilder() {
    return new RestTemplate();
}

}
