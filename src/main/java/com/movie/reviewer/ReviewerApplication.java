package com.movie.reviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ReviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewerApplication.class, args);
	}

}
