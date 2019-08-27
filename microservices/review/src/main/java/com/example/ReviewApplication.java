package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.repository.ReviewRepository;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ReviewRepository reviewRepository) {
		return args -> {
//			reviewRepository.findByItemId(2L).forEach(item -> System.out.println(item));
		};

	}

}
