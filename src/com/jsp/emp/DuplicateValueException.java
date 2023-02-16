package com.jsp.emp;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateValueException extends SQLIntegrityConstraintViolationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {

		return "This Id is already present in the database, plz enter valid id";
	}

}
