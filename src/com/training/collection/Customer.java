package com.training.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	private int customerNumber;
	private String customerName;
	private double salary;
	
	// Constructor
	public Customer(int customerNumber, String customerName, double salary) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.salary = salary;
	}
	
	// Getters
	public int getCustomerNumber() {
		return this.customerNumber;
	}
	public String getCustomerName() {
		return this.customerName;
	}
	public double getSalary() {
		return this.salary;
	}
	
	// Setters
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public String display() {
		return "Customer Number: " + customerNumber + ", Customer Name: " + customerName + ", Salary: " + salary;
	}
}
