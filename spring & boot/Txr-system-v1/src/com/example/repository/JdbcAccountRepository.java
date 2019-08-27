package com.example.repository;

import org.apache.log4j.Logger;

import com.example.model.Account;

public class JdbcAccountRepository {

	private static Logger logger = Logger.getLogger("txr-system");

	public JdbcAccountRepository() {
		logger.info("JdbcAccountRepository instance created...");
	}

	public Account load(String num) {
		logger.info("loading account - " + num);
		// ...
		return new Account("1", 1000.00);
	}

	public Account update(Account account) {
		logger.info("updating account.." + account.getNum());
		// ...
		return account;
	}

}
