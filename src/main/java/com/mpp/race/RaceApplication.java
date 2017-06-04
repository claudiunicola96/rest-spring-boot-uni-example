package com.mpp.race;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class RaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaceApplication.class, args);
	}
}
