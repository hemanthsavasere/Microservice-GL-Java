package com.example.service;

import org.apache.log4j.Logger;

import com.example.model.Account;
import com.example.repository.AccountRepository;

public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("txr-system");

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrServiceImpl instance created...");
	}

	public boolean txr(double amount, String fromAccNum, String toAccNum) {

		logger.info("txr initiated..");

		// load 'from' & 'to' accounts
		Account fromAccount = accountRepository.load(fromAccNum);
		Account toAccount = accountRepository.load(toAccNum);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// update accounts
		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		logger.info("txr success");

		return true;
	}

}
