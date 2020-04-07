package com.springboot.demo.app.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.app.cruddemo.dao.EmployeeDao;
import com.springboot.demo.app.cruddemo.dao.EmployeeRepository;
import com.springboot.demo.app.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee getEmpById(int id) {
		Optional< Employee> employee= employeeRepository.findById(id);
		if (employee.isPresent()) {
			Employee theEmployee= employee.get();
			return theEmployee;
		}else {
			throw new RuntimeException("Unable to find Employee of id :"+ id );
		}
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmpById(int empId) {
		employeeRepository.deleteById(empId);

	}

}
