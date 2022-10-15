package com.rakesh.exceptions;
/**
-File Name          : PatientNotFoundException
-Author Name        : Rakesh
-Description        : Exception handling for PatientNotFoundException 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
public class PatientNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PatientNotFoundException() {

	}
	public PatientNotFoundException(String message) {
			super(message);
	}


}
