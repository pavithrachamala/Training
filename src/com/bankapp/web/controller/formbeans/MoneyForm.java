package com.bankapp.web.controller.formbeans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MoneyForm {
	@NotNull(message="from account can not be lelf blank")
	private Integer fromAccount;
	
	@NotNull(message="amount can not be lelf blank")
	@Max(message="value should be less then 200000", value=200000)
	@Min(message="value should be more then 500", value=500)
	private Double amount;

	public Integer getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
	
}
