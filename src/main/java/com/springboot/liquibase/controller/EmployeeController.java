package com.springboot.liquibase.controller;

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

import com.springboot.liquibase.entity.Employee;
import com.springboot.liquibase.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("create")
	public Employee createEmployee(@RequestBody final Employee employee) {
		return this.employeeService.createEmployee(employee);
	}
	
	@GetMapping("/retrieve")
	public List<Employee> getAllEmployee(){
		return this.employeeService.getAllEmployee();
	}
	
	@GetMapping("/retrieve/{id}")
	public Employee getEmployeeById(@PathVariable final Long id){
		return this.employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody final Employee employeeDetails) {
		return this.employeeService.updateEmployee(id, employeeDetails);
	}
	
	@DeleteMapping("/remove")
	public void deleteEmployee(@PathVariable final Long id) {
		this.employeeService.deleteEmployee(id);
	}
}
