package com.springboot.demo.app.cruddemo.service;

import java.util.List;

import com.springboot.demo.app.cruddemo.entity.Employee;

public interface EmployeeService {
	
public List<Employee> getAllEmployee();
	
	public Employee getEmpById(int id);
	
	public void save(Employee employee);
	
	public void deleteEmpById(int empId);
	

}
