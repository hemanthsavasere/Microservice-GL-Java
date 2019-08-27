package com.example;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.TxrSystemConfiguration;
import com.example.service.TxrService;

public class App {

	private static Logger logger = Logger.getLogger("txr-system");

	public static void main(String[] args) {

		// ------------------------------------------
		// Init/boot
		// ------------------------------------------

		ConfigurableApplicationContext context = null;
		context = new AnnotationConfigApplicationContext(TxrSystemConfiguration.class);

		logger.info("");

		// ------------------------------------------
		// Use
		// ------------------------------------------

		TxrService txrService = context.getBean(TxrService.class);

		txrService.txr(100.00, "1", "2");

		logger.info("");

		// ------------------------------------------
		// destroy
		// ------------------------------------------

		// ..
		context.close();

	}

}
