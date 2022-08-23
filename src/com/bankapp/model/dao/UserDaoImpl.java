package com.bankapp.model.dao;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.bankapp.model.entities.AppUser;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public void addUser(AppUser user) {
		getSession().save(user);
	}

	@Override
	public AppUser getUserByEmail(String email) {

		return (AppUser) getSession()
				.createQuery("select u from AppUser u where u.email=:email and valid=true")
				.setParameter("email", email).uniqueResult();

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<AppUser> getAllUsers() {
		return getSession().createQuery("from AppUser").list();
	}
}











