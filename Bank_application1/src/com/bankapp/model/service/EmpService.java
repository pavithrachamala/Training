package com.bankapp.model.service;

import com.bankapp.model.persistance.Emp;

public interface EmpService {
	public void addEmp(Emp emp);
	public Emp getEmp(String email,String password);


}
