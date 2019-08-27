package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository("jpaAccountRepository")
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Account load(String num) {
		return em.find(Account.class, num);
	}

	@Override
	public Account update(Account account) {
		return em.merge(account);
	}

}
