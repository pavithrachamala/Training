package com.bankapp.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserNotFoundExcpetion;
import com.bankapp.model.service.UserService;
@RequestMapping(path="/api/admin")
@RestController
public class UserContoller {
	@Autowired
	private UserService userservice;

	@GetMapping(path = "/allusers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return userservice.findAll();
	}

	@PostMapping(path = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User> addUser(@RequestBody User user) {

		return new ResponseEntity<User>(userservice.addUser(user), HttpStatus.OK);
	}

	@DeleteMapping(path = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User> deleteUser(@PathVariable(name = "id") Long id) {
		userservice.deleteUser(id);

		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
		userservice.updateUser(id, user);

		return new ResponseEntity<User>(userservice.updateUser(id, user), HttpStatus.OK);
	}

	@GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User> getAnUsers(@PathVariable(name = "id") Long id) {
		User user = userservice.findUserById(id).orElseThrow(UserNotFoundExcpetion::new);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
