package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.example.service.GLService;

@Configuration
@EnableAutoConfiguration
public class App {

	public static void main(String[] args) {

		// --------------------------------------------------
		// Init / boot
		// --------------------------------------------------
		
		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(App.class, args);

		// --------------------------------------------------
		// Use
		// --------------------------------------------------

		GLService glService = context.getBean(GLService.class);
		if (glService != null) {
			System.out.println("glService in context");
		}

		// --------------------------------------------------
		// destroy
		// --------------------------------------------------
		context.close();

	}

}
