package com.example.employee.exception;

public class InvalidEmployeeException extends RuntimeException{
	public InvalidEmployeeException(String msg) {
		super(msg);
	}
}
