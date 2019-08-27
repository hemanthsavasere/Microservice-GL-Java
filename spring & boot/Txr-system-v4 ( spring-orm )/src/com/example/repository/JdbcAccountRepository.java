package com.example.repository;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository("jdbcAccountRepository")
@Qualifier(value = "jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("txr-system");

	private DataSource dataSource;

	public JdbcAccountRepository(DataSource dataSource) {
		this.dataSource = dataSource;
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
