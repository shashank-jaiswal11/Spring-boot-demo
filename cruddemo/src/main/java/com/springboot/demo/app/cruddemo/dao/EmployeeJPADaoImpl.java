package com.springboot.demo.app.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.app.cruddemo.entity.Employee;

@Repository
public class EmployeeJPADaoImpl implements EmployeeDao {

	@Autowired

	private EntityManager entityManger;

	@Override
	public List<Employee> getAllEmployee() {
		Query theQuery = entityManger.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getEmpById(int id) {
		Employee employee= entityManger.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {

	}

	@Override
	public void deleteEmpById(int empId) {

	}

}
