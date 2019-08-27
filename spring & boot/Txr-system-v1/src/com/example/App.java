package com.example;

import org.apache.log4j.Logger;

import com.example.service.TxrServiceImpl;

public class App {

	private static Logger logger = Logger.getLogger("txr-system");

	public static void main(String[] args) {

		// ------------------------------------------
		// Init/boot
		// ------------------------------------------

		TxrServiceImpl txrService = new TxrServiceImpl();

		logger.info("");

		// ------------------------------------------
		// Use
		// ------------------------------------------

		txrService.txr(100.00, "1", "2");
		logger.info("");
		txrService.txr(100.00, "2", "1");

		logger.info("");

		// ------------------------------------------
		// destroy
		// ------------------------------------------

		// ..

	}

}
