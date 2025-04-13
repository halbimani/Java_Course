package com.example.employee.service;

import java.util.List;
import java.util.UUID;

import com.example.employee.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee addEmployee(Employee employee);
	public Employee getEmpById(UUID id);
	public Employee updateEmployee(Employee employee);
	public String deleteEmployee(String name);
	public Employee getByName(String name);
}
