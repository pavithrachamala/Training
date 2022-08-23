package com.bankapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SessionFactory factory;
	public Session getSession()
	{
		return factory.getCurrentSession();
	}

	@Override
	public void addEmp(Emp emp) {
		getSession().save(emp);
		
	}

	@Override
	public Emp getEmp(String email, String password) {
		@SuppressWarnings("unchecked")
		List<Emp> emp=getSession().createQuery("select p from Emp p where p.email=:email and p.password=:password")
				.setString("email", email).setString("password", password).list();
		if(emp.size()>0)
			return emp.get(0);
		else
			throw new EmpNotFoundException("emp with this mail"+email+"is not found");
	
	}

}
