package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.User;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
//import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.repo.UserRepository;
//import com.bankapp.model.repo.TransactionLogRepository;
//import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.AccountService;

@EnableTransactionManagement
@SpringBootApplication
public class Finalprojectbankappv1Application implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@SuppressWarnings("unused")
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	public static void main(String[] args) {
		SpringApplication.run(Finalprojectbankappv1Application.class, args);
	}

	@Autowired
	private AccountService accountService;

	public void run(String... args) throws Exception {
/*
		Customer customer = new Customer("anu", "anu@gmail.com", "5454545545", "Guntur", "Guntur", "india");
		Customer customer2 = new Customer("ajay", "ajay@gmail.com", "54598545545", "hyderabad", "telangana", "india");
		Customer customer3 = new Customer("hemu", "hemu@gmail.com", "5974545545", "banglore", "Karnataka", "india");

		Account account = new Account(2000.0, customer, false);
		Account account2 = new Account(1000.0, customer2, false);
		Account account3 = new Account(2500.0, customer3, false);

		customer.setAccount(account);
		customer2.setAccount(account2);
		customer3.setAccount(account3);

		accountRepository.save(account);
		accountRepository.save(account2);
		accountRepository.save(account3);

		User user1 = new User("anu", "anu", "anu@gmail.com", "54545455", "Guntur",
				new String[] { "ROLE_ADMIN", "ROLE_MGR", "ROLE_CLERK" }, true);

		User user2 = new User("hemu", "hemu", "hemu@gmail.com", "54545455", "hyderabad",
				new String[] { "ROLE_MGR", "ROLE_CLERK" }, true);

		User user3 = new User("ajay", "ajay", "ajay@gmail.com", "54545455", "chennai", new String[] { "ROLE_CLERK" },
				true);

		User user4 = new User("amani", "amani", "amani@gmail.com", "54545455", "bangalore",
				new String[] { "ROLE_CLERK" }, true);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);

		accountService.deposit(2L, 100);
		

		accountService.withdraw(3L, 1000);
		accountService.transfer(3L, 2L, 200);
	
		//accountService.withdraw(3L, 1000);
*/}
}
