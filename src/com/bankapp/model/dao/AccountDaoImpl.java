package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
import com.bankapp.model.exceptions.AccountNotFoundException;
import com.bankapp.model.exceptions.NotSufficientFundException;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Account addAccount(Account account) {
		getSession().save(account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		getSession().update(account);
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAallAccounts() {
		return getSession().createQuery("select a from Account a").list();
	}

	@Override
	public void deposit(int accountId, double amount) {
		Account account=getAccountById(accountId);
		account.setBalance(account.getBalance()+amount);
		getSession().update(account);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account account=getAccountById(accountId);
		if(account.getBalance()<amount)
			throw new NotSufficientFundException("not sufficient fund exception");
		
		account.setBalance(account.getBalance() - amount);
		getSession().update(account);
	}

	//update Stock set stockName = :stockName" + " where stockCode = :stockCode
	@Override
	public void blockAccount(int accountId) {
		Query query= getSession().createQuery
				("update Account set blocked=:blocked where id=:id");
		query.setParameter("blocked", true);
		query.setParameter("id", accountId);
		int result =query.executeUpdate();
	}

	@Override
	public void deleteAccount(int accountId) {

	}

	@Override
	public void unBlockAccount(int accountId) {
		Query query= getSession().createQuery
				("update Account set blocked=:blocked where id=:id");
		query.setParameter("blocked", false);
		query.setParameter("id", accountId);
		int result =query.executeUpdate();
	}

	
	
	
	@Override
	public Account getAccountById(int accountId) {
		Account account= (Account) getSession().get(Account.class, accountId);
		if (account == null)
			throw new AccountNotFoundException("Account with id:" + accountId
					+ " is not found");
		return account;
	}

}
