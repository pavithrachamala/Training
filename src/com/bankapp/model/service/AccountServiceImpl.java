package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.entities.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public void transfer(int fromAccount, int toAccount, double amount) {
		accountDao.withdraw(fromAccount, amount);
		accountDao.deposit(toAccount, amount);

	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.addAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public List<Account> getAallAccounts() {
		return accountDao.getAallAccounts();
	}

	@Override
	public Account getAccountById(int accountId) {
		Account account = accountDao.getAccountById(accountId);
		
		return account;
	}

	@Override
	public void deposit(int accountId, double amount) {
		accountDao.deposit(accountId, amount);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		accountDao.withdraw(accountId, amount);
	}

	@Override
	public void blockAccount(int accountId) {
		accountDao.blockAccount(accountId);
	}

	@Override
	public void deleteAccount(int accountId) {
		accountDao.deleteAccount(accountId);
	}

	@Override
	public void unBlockAccount(int accountId) {
		accountDao.unBlockAccount(accountId);
	}

}
