package com.bankapp.model.dao;

import com.bankapp.model.entities.Account;
import java.util.*;
public interface AccountDao {

	public Account addAccount(Account account);
	public Account updateAccount(Account account);
	
	public List<Account> getAallAccounts();
	
	public Account getAccountById(int accountId);
	
	public void deposit(int accountId, double amount);
	public void withdraw(int accountId, double amount);
	
	public void blockAccount(int accountId);
	public void deleteAccount(int accountId);//logical delete
	
	public void unBlockAccount(int accountId);
	
	
}
