package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.persistance.Account;
import com.bankapp.model.persistance.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao dao;
	

	@Override
	public void transfer(int from, int to, int amount) {
		deposit(to,amount);
		withdraw(from,amount);
	}

	@Override
	public void deposit(int accountNo, int amount) {
		Account account=dao.find(accountNo);
		int currentBalance=account.getBalance();
		int updateBalance=currentBalance+amount;
		account.setBalance(updateBalance);
		dao.update(account);
	}

	@Override
	public Account getAccount(int accountNo) {
		
		return dao.find(accountNo);
	}

	@Override
	public void withdraw(int accountNo, int amount) {
		Account account=dao.find(accountNo);
		int currentBalance=account.getBalance();
		int updateBalance=currentBalance-amount;
		account.setBalance(updateBalance);
		dao.update(account);

	}

	@Override
	public void add(Account account) {
		dao.add(account);
	}

	@Override
	public void update(Account account) {
		
		dao.update(account);
		
	}
	

}
