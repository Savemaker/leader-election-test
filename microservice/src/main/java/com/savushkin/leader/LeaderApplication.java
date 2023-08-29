package com.savushkin.leader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LeaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaderApplication.class, args);
	}

}
