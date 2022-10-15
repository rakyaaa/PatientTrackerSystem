package com.rakesh.exceptions;
/**
-File Name          : DoctorNotFoundException
-Author Name        : Rakesh
-Description        : Exception handling for DoctorNotFoundException 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
public class DoctorNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DoctorNotFoundException() {

	}
	public DoctorNotFoundException(String message) {
			super(message);
	}


}
