package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping(path="/api")
public class AccountRestController {
	
	@Autowired
	private AccountService service;
	
	
	@PostMapping(path="/createaccount",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addAccount(@RequestBody AccountRequest accountreq)
	{
		Account account=new Account(accountreq.getBalance(), false);
		Customer customer=new Customer(accountreq.getName(), accountreq.getEmail(), accountreq.getPhone(), 
				accountreq.getAddress(), accountreq.getCity(), accountreq.getCountry());
		
		account.setCustomer(customer);
		service.createAccount(account);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(path="/account/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccount(@PathVariable(name="accountNumber")Long accountNumber)
	{
		return new ResponseEntity<Account>(service.findByAccountNumber(accountNumber),HttpStatus.OK);
	}
	
	@GetMapping(path="/account/deposite/{accountNumber}/{amount}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> deposite(@PathVariable(name="accountNumber")Long accountNumber,
			@PathVariable(name="amount")double amount)
	{
		service.deposit(accountNumber, amount);
		return new ResponseEntity<Account>(HttpStatus.OK);
		
	}
	
	@GetMapping(path="/allaccounts",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts()
	{
		return new ResponseEntity<List<Account>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/account/withdraw/{accountNumber}/{amount}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> withdraw(@PathVariable(name="accountNumber")Long accountNumber,
			@PathVariable(name="amount")double amount)
	{
		service.withdraw(accountNumber, amount);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@GetMapping(path="/account/transfer/{fromAccNumber}/{toAccNumber}/{amount}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> transfer(@PathVariable(name="fromAccNumber")Long fromAccNumber,
			@PathVariable(name="toAccNumber")Long toAccNumber,@PathVariable(name="amount")double amount)
	{
		service.transfer(fromAccNumber, toAccNumber, amount);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@GetMapping(path="/deleteaccount/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> delete(@PathVariable(name="accountNumber")Long accountNumber)
	{
		service.deleteAccount(accountNumber);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
}
