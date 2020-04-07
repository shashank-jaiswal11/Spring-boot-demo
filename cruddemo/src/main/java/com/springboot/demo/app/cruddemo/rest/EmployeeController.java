package com.springboot.demo.app.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.demo.app.cruddemo.entity.Employee;
import com.springboot.demo.app.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmployee")
	public String getEmployeeList(Model theEmployee) {
		List<Employee> employeeList= employeeService.getAllEmployee();
		theEmployee.addAttribute("employees", employeeList);
		return "employees/list-employee";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/api/getEmployee";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model model) {
		Employee theEmployee = employeeService.getEmpById(theId);
		
		model.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId,Model model) {
		employeeService.deleteEmpById(theId);
		return "redirect:/api/getEmployee";
	}
}
