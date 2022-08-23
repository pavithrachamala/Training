package com.bankapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
	@Autowired
	private SessionFactory factory;
	public Session getSession(){
		return factory.getCurrentSession();
	}
	@Override
	public void update(Account account) {
		getSession().update(account);
	}

	@Override
	public Account find(int accountNo) {
		
		List list=getSession().createQuery("select a from Account a where a.accountNo=:accountNo").setInteger("accountNo", accountNo).list();
		Account account=(Account) list.get(0);
		return account;
	}
	@Override
	public void add(Account account) {
		getSession().save(account);
	
	}
	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}
}
