package com.example.employee.exception;

public class InvalidIdException extends RuntimeException {
	public InvalidIdException(String msg) {
		super(msg);
	}
}
