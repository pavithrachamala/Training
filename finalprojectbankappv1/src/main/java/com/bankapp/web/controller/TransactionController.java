package com.bankapp.web.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.bean.DepositAndWithdrawRequests;
import com.bankapp.web.controller.bean.TransferRequests;

@RequestMapping(path = "api")
@RestController
public class TransactionController {
	@Autowired
	private AccountService accountservice;

	@PostMapping(path = "transaction/deposit")
	public ResponseEntity<Account> depositAmount(@RequestBody DepositAndWithdrawRequests req, Principal principal) {
		accountservice.deposit(req.getAccNumber(), req.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}

	@PostMapping(path = "transaction/withdraw")
	public ResponseEntity<Account> withdrawAmount(@RequestBody DepositAndWithdrawRequests req, Principal principal) {
		accountservice.withdraw(req.getAccNumber(), req.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}

	@PostMapping(path = "transaction/transfer")
	public ResponseEntity<Account> transferAmount(@RequestBody TransferRequests req, Principal principal) {
		accountservice.transfer(req.getFromAcc(), req.getToAcc(), req.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}

}

/*
 * @PostMapping(path = "/account/deposit/", consumes =
 * MediaType.APPLICATION_JSON_VALUE, produces =
 * MediaType.APPLICATION_JSON_VALUE)
 * 
 * public ResponseEntity<Account> depositInAccount(@PathVariable(name = "id")
 * Long accountNumber,
 * 
 * @PathVariable(name = "amount") Double amount) {
 * accountservice.deposit(accountNumber, amount);
 * 
 * return new ResponseEntity<Account>(HttpStatus.OK); }
 */
/*
 * @PostMapping(path = "/transaction/deposit", consumes =
 * MediaType.APPLICATION_JSON_VALUE, produces =
 * MediaType.APPLICATION_JSON_VALUE)
 * 
 * public ResponseEntity<Account> addAccount(@RequestBody Account account) {
 * 
 * return new ResponseEntity<Account>(accountservice.addAccount(account),
 * HttpStatus.OK); }
 */
