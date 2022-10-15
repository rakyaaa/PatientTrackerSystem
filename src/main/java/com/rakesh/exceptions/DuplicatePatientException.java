package com.rakesh.exceptions;
/**
-File Name          : DuplicatePatientException
-Author Name        : Rakesh
-Description        : Exception handling for DuplicatePatientExceptionn 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
public class DuplicatePatientException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatePatientException() {
		
	}
	
	public DuplicatePatientException(String message) {
		super(message);
	}

}
