package com.bankapp.model.persistance;

public interface EmpDao {
	public void addEmp(Emp emp);
	public Emp getEmp(String email,String password);

}
