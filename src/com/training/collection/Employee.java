package com.training.collection;

public class Employee {
	private int employeeNumber;
	private String employeeName;
	private String department;
	private double salary;
	
	// Constructor
	public Employee(int employeeNumber, String employeeName, String department, double salary) {
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.department = department;
		this.salary = salary;
	}
	
	// Getters
	public int getEmployeeNumber() {
		return this.employeeNumber;
	}
	public String getEmployeeName() {
		return this.employeeName;
	}
	public String getDepartment() {
		return this.department;
	}
	public double getSalary() {
		return this.salary;
	}
	
	// Setters
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee Number: " + employeeNumber + ", Employee Name: " + employeeName + ", Department: " + department + ", Salary: " + salary + "\n";
	}
}
