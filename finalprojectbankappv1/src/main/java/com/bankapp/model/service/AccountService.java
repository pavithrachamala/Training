package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;

public interface AccountService {
	public void blockAccount(Long accountNumber);

	public void createAccount(Account account);

	public void deposit(Long accountNumber, double amount);

	public void withdraw(Long accountNumber, double amount);

	public void transfer(Long fromAccNumber, Long toAccNumber, double amount);

	public void deleteAccount(Long id);

	public Account addAccount(Account account);

	public Account updateAccount(Long id, Account account);

	public List<Account> getAllAccounts();

}
