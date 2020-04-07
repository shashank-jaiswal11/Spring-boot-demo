package com.springboot.demo.app.cruddemo.dao;

import java.util.List;

import com.springboot.demo.app.cruddemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployee();
	
	public Employee getEmpById(int id);
	
	public void save(Employee employee);
	
	public void deleteEmpById(int empId);
	
	

}
