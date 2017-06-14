package com.aakam.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(final String... args) {

		logger.info("inserting {}", (Object) args);

		SpringApplication.run(Application.class, args);

		logger.info("exiting");
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			System.out.println("TEST TEST TEST");
		};
	}
}
