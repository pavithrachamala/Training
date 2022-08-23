package com.bankapp.model.dao;
import java.util.*;


import com.bankapp.model.entities.AppUser;
public interface UserDao {
	public List<AppUser> getAllUsers();
	public void addUser(AppUser user);
	public AppUser getUserByEmail(String email);

}
