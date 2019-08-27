package com.example;

import org.apache.log4j.Logger;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

public class App {

	private static Logger logger = Logger.getLogger("txr-system");

	public static void main(String[] args) {

		// ------------------------------------------
		// Init/boot
		// ------------------------------------------

		AccountRepository jdbcAccountRepository = new JdbcAccountRepository();

		TxrService txrService = new TxrServiceImpl(jdbcAccountRepository);

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
