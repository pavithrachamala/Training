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

import com.bankapp.model.entities.Account;

import com.bankapp.model.service.AccountService;

@RequestMapping(path = "/api/mgr")
@RestController
public class AccountController {
	@Autowired
	private AccountService accountservice;

	@GetMapping(path = "/allaccounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccounts() {
		return accountservice.getAllAccounts();
	}

	@PostMapping(path = "/addaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Account> addAccount(@RequestBody Account account) {

		return new ResponseEntity<Account>(accountservice.addAccount(account), HttpStatus.OK);
	}

	@DeleteMapping(path = "account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Account> deleteAccount(@PathVariable(name = "id") Long id) {
		accountservice.deleteAccount(id);

		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "account/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Account> updateAccount(@PathVariable(name = "id") Long id, @RequestBody Account account) {
		accountservice.updateAccount(id, account);

		return new ResponseEntity<Account>(accountservice.updateAccount(id, account), HttpStatus.OK);
	}

	/*
	 * @GetMapping(path = "home") public String home() { return "hello to home";
	 * }
	 * 
	 * @GetMapping(path="clerk") public String helloClerk(){
	 * 
	 * return "hello to clerk"; }
	 * 
	 * @GetMapping(path="mgr") public String helloMgr(){ return "hello to mgr";
	 * }
	 * 
	 * @GetMapping(path="admin") public String helloAdmin(){ return
	 * "hello to admin"; }
	 */

}
