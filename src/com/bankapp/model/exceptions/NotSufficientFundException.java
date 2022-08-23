package com.bankapp.model.exceptions;

public class NotSufficientFundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotSufficientFundException(String msg){
		super(msg);
	}

}
