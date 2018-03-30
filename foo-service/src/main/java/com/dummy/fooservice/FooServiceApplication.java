package com.dummy.fooservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FooServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooServiceApplication.class, args);
	}
}
