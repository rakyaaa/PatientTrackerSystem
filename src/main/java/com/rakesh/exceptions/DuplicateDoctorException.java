package com.rakesh.exceptions;
/**
-File Name          : DuplicateDoctorException
-Author Name        : Rakesh
-Description        : Exception handling for DuplicateDoctorException 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
public class DuplicateDoctorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateDoctorException() {
		
	}

public DuplicateDoctorException(String msg) {
		super(msg);
	}
}
