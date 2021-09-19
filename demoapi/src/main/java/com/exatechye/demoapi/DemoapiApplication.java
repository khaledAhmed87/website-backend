package com.exatechye.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
public class DemoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoapiApplication.class, args);
	}

}
