package com.example;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

//		AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
//		TxrService txrService = new TxrServiceImpl(jdbcAccountRepository);

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
