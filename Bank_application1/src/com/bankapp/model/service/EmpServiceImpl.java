package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.persistance.Emp;
import com.bankapp.model.persistance.EmpDao;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{
@Autowired	
private EmpDao dao;
	@Override
	public void addEmp(Emp emp) {
		dao.addEmp(emp);
		
	}

	@Override
	public Emp getEmp(String email, String password) {
		
		return dao.getEmp(email, password);
	}

}
