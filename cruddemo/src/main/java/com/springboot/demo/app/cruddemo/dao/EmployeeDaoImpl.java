package com.springboot.demo.app.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.app.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	// define field for entity manager
	@Autowired
	private EntityManager entityManger;

	@Override
	public List<Employee> getAllEmployee() {

		// get the hibernate session
		Session currentSession = entityManger.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// rerutn the result
		return employees;
	}

	@Override
	public Employee getEmpById(int id) {
		// get the hibernate session
		Session currentSession = entityManger.unwrap(Session.class);
		// get the employee
		Employee theEmloyee = currentSession.get(Employee.class, id);
		// return the employee
		return theEmloyee;
	}

	@Override
	public void save(Employee employee) {
		// get the hibernate session
		Session currentSession = entityManger.unwrap(Session.class);

		currentSession.saveOrUpdate(employee);

	}

	@Override
	public void deleteEmpById(int empId) {
		Session currentSession = entityManger.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", empId);
		theQuery.executeUpdate();
	}

}
