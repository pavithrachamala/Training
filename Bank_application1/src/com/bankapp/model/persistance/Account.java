package com.bankapp.model.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="acc_table5")
public class Account {
@Id
@GeneratedValue
private int Id;
private int accountNo;
private int balance;
private String accountHolder;
public int getAccountNo() {
	return accountNo;
}
public void setAccountNo(int accountNo) {
	this.accountNo = accountNo;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public String getAccountHolder() {
	return accountHolder;
}
public void setAccountHolder(String accountHolder) {
	this.accountHolder = accountHolder;
}

public Account(int accountNo, int balance, String accountHolder) {
	super();
	this.accountNo = accountNo;
	this.balance = balance;
	this.accountHolder = accountHolder;
}
public Account() {
	// TODO Auto-generated constructor stub
}
}
