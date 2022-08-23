package com.bankapp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="acc_table")
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double balance;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "account_type")
	private AccountType type;
	
	private boolean blocked;
	private boolean deleted;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public Account(String name, double balance, AccountType type,
			boolean blocked, boolean deleted) {
		this.name = name;
		this.balance = balance;
		this.type = type;
		this.blocked = blocked;
		this.deleted = deleted;
	}
	public Account() {}
}
