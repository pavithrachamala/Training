package com.bankapp.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.model.persistance.Account;
import com.bankapp.model.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostConstruct
	public void init(){
	accountService.add(new Account(121, 100, "pavi"));	
	accountService.add(new Account(122, 111, "sai"));	
	}
	
	/*@RequestMapping(value="/")
	public String home(){
		//mv.addAttribute("accountBean",new AccountBean());
		return "redirect:home";
	}*/
	
	@RequestMapping(value="home")
	public String home(ModelMap mv){
		mv.addAttribute("accountBean",new AccountBean());
		return "home";
	}
	@RequestMapping(value="transfer",method=RequestMethod.POST)
	public String homePost(AccountBean accountBean){
		accountService.transfer(accountBean.getFrom(),accountBean.getTo(), accountBean.getAmount());
		return "success";
	}

}
