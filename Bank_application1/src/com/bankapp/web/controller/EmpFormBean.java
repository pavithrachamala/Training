package com.bankapp.web.controller;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmpFormBean {
	@NotEmpty(message="email should be filled")
	@Email(message="enter in correct format")
	private String email;
	@NotEmpty(message="password should not empty")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
