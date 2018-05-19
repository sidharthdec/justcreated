package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class DemoconfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoconfigclientApplication.class, args);
	}
}
