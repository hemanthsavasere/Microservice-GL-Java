package com.example.repository;

import com.example.model.Account;

public interface AccountRepository {

	Account load(String num);

	Account update(Account account);

}