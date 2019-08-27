package com.example.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.example.service", "com.example.repository" })
public class TxrSystemConfiguration {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		return dataSource;
	}
//
//	@Bean
//	public AccountRepository accountRepository() {
//		return new JdbcAccountRepository(dataSource());
//	}
//
//	@Bean
//	public TxrService txrService() {
//		return new TxrServiceImpl(accountRepository());
//	}

}
