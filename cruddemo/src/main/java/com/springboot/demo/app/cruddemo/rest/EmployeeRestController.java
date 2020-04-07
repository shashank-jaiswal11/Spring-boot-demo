package com.springboot.demo.app.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.app.cruddemo.entity.Employee;
import com.springboot.demo.app.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/testapi")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employee/{id}")
	public Employee getAllEmployeeById(@PathVariable int id) {
		Employee employee = employeeService.getEmpById(id);
		if (employee == null) {
			throw new RuntimeException("Employee doesn't exist for the id : " + id);
		}
		return employee;
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);

		return employee;
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		Employee employee = employeeService.getEmpById(id);
		if (employee == null) {
			throw new RuntimeException("Employee doesn't exist for the id : " + id);
		}
		employeeService.deleteEmpById(id);
		
		return "Succesfully Deleted the id :" + id;
	}

}
