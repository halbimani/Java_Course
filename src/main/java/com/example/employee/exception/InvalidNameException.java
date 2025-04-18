package com.example.employee.exception;

public class InvalidNameException extends RuntimeException {
	public InvalidNameException(String msg) {
		super(msg);
	}
}
