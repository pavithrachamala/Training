package com.bankapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.formbeans.AccountForm;
import com.bankapp.web.controller.formbeans.MoneyForm;

@Controller
@RequestMapping("clerk")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "allaccounts", method = RequestMethod.GET)
	public ModelAndView allAccounts(ModelAndView mv) {
		mv.setViewName("all_accounts");
		mv.addObject("accounts", accountService.getAallAccounts());
		return mv;

	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public String transferGet(Model model) {
		model.addAttribute("accountForm", new AccountForm());
		return "fund_transfer";

	}

	
	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	public String withdrawGet(Model model) {
		model.addAttribute("moneyForm", new MoneyForm());
		return "deposit_form";

	}

	@RequestMapping(value = "withdraw", method = RequestMethod.POST)
	public String withdrawPost(
			@Valid @ModelAttribute(value = "moneyForm") MoneyForm moneyForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "deposit_form";
		}
		accountService.withdraw(moneyForm.getFromAccount(),moneyForm.getAmount());

		return "redirect:allaccounts";
	}
	
	
	@RequestMapping(value = "deposit", method = RequestMethod.GET)
	public String depositGet(Model model) {
		model.addAttribute("moneyForm", new MoneyForm());
		return "deposit_form";

	}

	@RequestMapping(value = "deposit", method = RequestMethod.POST)
	public String depositPost(
			@Valid @ModelAttribute(value = "moneyForm") MoneyForm moneyForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "deposit_form";
		}
		accountService.deposit(moneyForm.getFromAccount(),moneyForm.getAmount());

		return "redirect:allaccounts";
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transferPost(
			@Valid @ModelAttribute(value = "accountForm") AccountForm accountForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "fund_transfer";
		}
		accountService.transfer(accountForm.getFromAccount(),
				accountForm.getToAccount(), accountForm.getAmount());
		return "redirect:allaccounts";

	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		// accountService.addAccount(new Account("raj", 1000,
		// AccountType.SAVING, false, false));
		// accountService.addAccount(new Account("ekta", 1000,
		// AccountType.SAVING, false, false));
		// accountService.addAccount(new Account("ramesh", 1000,
		// AccountType.SAVING, true, true));

		mv.setViewName("home");
		mv.addObject("appname", "bank app");
		return mv;

	}

}
