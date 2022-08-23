package com.bankapp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="appuser_table")
public class AppUser {
	
	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	private String password;
	private String phone;
	private String address;
	private String[]roles;
	private boolean valid;// true is ok , false is blocked..
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
		this.password = encoder.encode(password);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public AppUser(String name, String email, String password, String phone,
			String address, String[] roles, boolean valid) {
	
		this.name = name;
		this.email = email;
		setPassword(password);
		this.phone = phone;
		this.address = address;
		this.roles = roles;
		this.valid = valid;
	}
	public AppUser() {}
	
}
