package com.kishore.accounts.exception;

public class CustomerAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistException(String message) {
		super(message);
	}
}
