package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.entities.AppUser;
@Service
@Transactional
public  class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(AppUser user) {
		userDao.addUser(user);
	}

	@Override
	public AppUser getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<AppUser> getAllUsers() {
		return userDao.getAllUsers();
	}


}
