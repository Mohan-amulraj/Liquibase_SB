package com.springboot.liquibase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.liquibase.entity.Employee;
import com.springboot.liquibase.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(final Employee employee) {
		return this.employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	public Employee getEmployeeById(final Long id) {
		return this.employeeRepository.findById(id).orElseThrow();
	}

	public Employee updateEmployee(final Long id, final Employee employeeDetails) {
		final Employee employee = this.employeeRepository.findById(id).orElseThrow();
		employee.setId(id);
		return this.employeeRepository.save(employeeDetails);
	}

	public void deleteEmployee(final Long id) {
		final Employee employee = this.employeeRepository.findById(id).orElseThrow();
		this.employeeRepository.delete(employee);
	}
}
