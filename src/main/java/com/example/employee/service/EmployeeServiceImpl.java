package com.example.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.exception.InvalidEmployeeException;
import com.example.employee.exception.InvalidIdException;
import com.example.employee.exception.InvalidNameException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		if (employee == null) {
			throw new InvalidEmployeeException("Enter a valid Employee");
		}
		if (employee.getEmpName() == null || employee.getEmpName().isEmpty()) {
			throw new InvalidEmployeeException("Enter a valid EmpName");
		}
		if (employee.getEmpId() == null || employee.getEmpId().equals("")) {
			throw new InvalidEmployeeException("Enter a valid EmpId");
		}
		if (employee.getSalary() <= 0) {
			throw new InvalidEmployeeException("Enter a valid Salary");
		}
		if (employee.getDepartment() == null || employee.getDepartment().isEmpty()) {
			throw new InvalidEmployeeException("Enter a valid Department");
		}
		return repository.save(employee);
	}
	
	@Override
	public Employee getEmpById(UUID id) {
		if (id == null || id.equals("")) {
			throw new InvalidIdException("Enter a valid ID");
		}
		Optional<Employee> object = repository.findById(null);
		if (object.isPresent()) {
			return object.get();
		} else {
			return null; 
		}
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		if (employee == null) {
			throw new InvalidEmployeeException("Enter a valid Employee");
		}
		if (employee.getEmpName() == null || employee.getEmpName().isEmpty()) {
			throw new InvalidEmployeeException("Enter a valid EmpName");
		}
		if (employee.getEmpId() == null || employee.getEmpId().equals("")) {
			throw new InvalidEmployeeException("Enter a valid EmpId");
		}
		if (employee.getSalary() <= 0) {
			throw new InvalidEmployeeException("Enter a valid Salary");
		}
		if (employee.getDepartment() == null || employee.getDepartment().isEmpty()) {
			throw new InvalidEmployeeException("Enter a valid Department");
		}
		
		UUID id=employee.getEmpId();
		Optional<Employee> object = repository.findById(id);
		if (object.isPresent()) {
			Employee newEmployee = object.get();
			newEmployee.setEmpName(employee.getEmpName());
			newEmployee.setSalary(employee.getSalary());
			newEmployee.setDepartment(employee.getDepartment());
			repository.save(newEmployee);
			return newEmployee;
		} else {
			return null;
		}
	}
	
	@Override
	public String deleteEmployee(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidIdException("Enters a valid name");
		}
		Optional<Employee> object = repository.findByEmpName(name);
		if (object.isPresent()) {
			Employee employee = object.get();
			UUID id = employee.getEmpId();
			repository.deleteById(id);
			return "Employee Record Deleted Successfully";
		} else {
			return "Employee does not exist";
		}
	}
	
	@Override
	public Employee getByName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidNameException("Enter a valid name");
		}
		Optional<Employee> object = repository.findByEmpName(name);
		if (object.isPresent()) {
			return object.get();
		} else {
			return null;
		}
	}
}
