package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.User;
import com.bankapp.model.repo.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}

	@Override
	public void blockUser(Long userId) {

	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(Long id, User user) {
		User UserToBeUpdate = userRepository.findById(id).orElseThrow(UserNotFoundExcpetion::new);
		UserToBeUpdate.setEmail(user.getEmail());
		return userRepository.save(UserToBeUpdate);
	}

	@Override
	public Optional<User> findUserById(Long id) {
		
		return userRepository.findById(id);
	}

}
