package com.bankapp.web.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.model.persistance.Emp;
import com.bankapp.model.persistance.EmpNotFoundException;
import com.bankapp.model.service.EmpService;



@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	Emp emp=null;
	
	/*@PostConstruct
	public void init()
	{
		empService.addEmp(new Emp("pavi@gmail.com","pavi5","admin"));
		empService.addEmp(new Emp("sai@gmail.com","sai5","mgr"));
		empService.addEmp(new Emp("veera@gmail.com","veera5","emp"));
	}*/
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login()
	{
		return "redirect:login";
	}
	
	@RequestMapping(value = "login")
	public String loginGet(HttpServletRequest req,ModelMap map) {
		map.addAttribute("empbean", new EmpFormBean());
		map.addAttribute("error",req.getParameter("error"));
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest req,@Valid @ModelAttribute(value="empbean") EmpFormBean empbean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "login";
		}else{
			try{
				emp=empService.getEmp(empbean.getEmail(),empbean.getPassword());
			}catch(EmpNotFoundException e){
				return "redirect:login?error=login interrupted";
			}
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("emp", emp);
		}
		return "redirect:home";
	}

}
