package com.example;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.TxrService;

public class App {

	private static Logger logger = Logger.getLogger("txr-system");

	public static void main(String[] args) {

		// ------------------------------------------
		// Init/boot
		// ------------------------------------------

		ConfigurableApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("txr-system.xml");

		logger.info("");

		// ------------------------------------------
		// Use
		// ------------------------------------------

		TxrService txrService = context.getBean(TxrService.class);

		txrService.txr(100.00, "1", "2");
		logger.info("");
		txrService.txr(100.00, "2", "1");

		logger.info("");

		// ------------------------------------------
		// destroy
		// ------------------------------------------

		// ..
		context.close();

	}

}
