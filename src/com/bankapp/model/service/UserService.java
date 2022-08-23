package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.AppUser;

public interface UserService {
	public void addUser(AppUser user);
	public AppUser getUserByEmail(String email);
	public List<AppUser> getAllUsers();
}
