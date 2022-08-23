package com.bankapp.web.controller.bean;

public class TransferRequests {
	public Long fromAcc;
	public Long toAcc;
	public double amount;

	public Long getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(Long fromAcc) {
		this.fromAcc = fromAcc;
	}

	public Long getToAcc() {
		return toAcc;
	}

	public void setToAcc(Long toAcc) {
		this.toAcc = toAcc;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransferRequests(Long fromAcc, Long toAcc, double amount) {
		super();
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferRequests [fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", amount=" + amount + "]";
	}

	public TransferRequests() {
		super();

	}

}
