package com.jsp.emp;

public class InvalidNameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {

		return "Enter Valid Name, characters allowed are (A-Z , a-z ,' ')";
	}
}
