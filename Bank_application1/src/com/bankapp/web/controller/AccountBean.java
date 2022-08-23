package com.bankapp.web.controller;

public class AccountBean {
	private int from;
	private int to;
	private int amount;

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public AccountBean(int from, int to, int amount) {

		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	public AccountBean() {
		// TODO Auto-generated constructor stub
	}
}
