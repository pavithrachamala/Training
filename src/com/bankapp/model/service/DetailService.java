package com.bankapp.model.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.AppUser;

@Service(value="detailService")
@Transactional
public class DetailService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	//@PostConstruct
	public void init(){
		userService.addUser(new AppUser("keshav", "keshav@gmail.com",
				"keshav121", "4445444345", "Delhi", new String[]{"ROLE_CLERK"}, true));
		userService.addUser(new AppUser("gunika", "gunika@gmail.com",
				"gunika121", "4445444345", "Delhi", new String[]{"ROLE_CLERK"}, true));
		userService.addUser(new AppUser("raj", "raj@gmail.com",
				"raj121", "4445444345", "Delhi", new String[]{"ROLE_ADMIN", "ROLE_MGR", "ROLE_CLERK"}, true));
		userService.addUser(new AppUser("ekta", "ekta@gmail.com",
				"ekta121", "4445444345", "Delhi", new String[]{ "ROLE_MGR","ROLE_CLERK"}, true));
	}
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		AppUser appUser=userService.getUserByEmail(email);
		if(appUser==null)
			throw new UsernameNotFoundException("username is not found");
		
		return new User(appUser.getEmail(), appUser.getPassword(), 
				AuthorityUtils.createAuthorityList(appUser.getRoles()));
		
	}

}






