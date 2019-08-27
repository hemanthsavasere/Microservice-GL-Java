package com.example.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("txr-system");

	private AccountRepository accountRepository;

	public TxrServiceImpl(@Qualifier("jpa") AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrServiceImpl instance created...");
	}

	@Transactional
	public boolean txr(double amount, String fromAccNum, String toAccNum) {

		logger.info("txr initiated..");

		// load 'from' & 'to' accounts
		Account fromAccount = accountRepository.findById(fromAccNum).get();
		Account toAccount = accountRepository.findById(toAccNum).get();

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// update accounts
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		logger.info("txr success");

		return true;
	}

}
