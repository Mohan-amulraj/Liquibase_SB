package com.springboot.liquibase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.liquibase.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
