package com.example.employee.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, UUID>{
	
	public Optional<Employee> findByEmpName(String name);
}
