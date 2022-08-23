package com.bankapp.model.service;

import com.bankapp.model.persistance.Account;

public interface AccountService {
	public void transfer(int from, int to, int amount); 
	public void deposit(int accountNo, int amount);
	public void withdraw(int accountNo, int amount);
	public Account getAccount(int accountNo);
	public void update(Account account);
	public void add(Account account);
}
