package com.bankapp.model.service;

import java.util.*;
import com.bankapp.model.entities.User;


public interface UserService {
	public User findByEmail(String email);

	public User addUser(User user);

	public List<User> findAll();

	public void blockUser(Long userId);

	public void deleteUser(Long userId);

	public User updateUser(Long id, User user);
	public Optional<User>findUserById(Long id);

	

}
