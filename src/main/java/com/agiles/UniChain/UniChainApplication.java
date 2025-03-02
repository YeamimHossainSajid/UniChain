package com.agiles.UniChain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UniChainApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniChainApplication.class, args);
	}
}
