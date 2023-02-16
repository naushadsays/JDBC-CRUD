package com.jsp.emp;

public class InvalidSIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {

		return "Enter Valid SID";
	}
}
