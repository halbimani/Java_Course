package com.example.employee.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private UUID empId;
	
	@Column(nullable=false)
	private String empName;
	
	@Column(nullable=false)
	private double salary;
	
	@Column(nullable=false)
	private String department;
	
	public Employee() {
		
	}
	
	public Employee(String empName, double salary, String department) {
		this.empName = empName;
		this.salary = salary;
		this.department = department;
	}
	
	// Getters
	public UUID getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public double getSalary() {
		return salary;
	}
	public String getDepartment() {
		return department;
	}
	
	// Setters
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
