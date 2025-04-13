package com.example.employee.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/v1/employee")
public class HomeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/all")
	public List<Employee> getEmployees() {
		return service.getAllEmployees();
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@GetMapping
	public Employee getByName(@RequestParam String name) {
		return service.getByName(name);
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping
	public String deleteEmployee(@RequestParam String name) {
		return service.deleteEmployee(name);
	}
}
