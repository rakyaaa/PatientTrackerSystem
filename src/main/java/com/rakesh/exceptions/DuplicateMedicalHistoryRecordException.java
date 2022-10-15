package com.rakesh.exceptions;
/**
-File Name          : DuplicateMedicalHistoryRecordException
-Author Name        : Rakesh
-Description        : Exception handling for DuplicateMedicalHistoryRecordException 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
public class DuplicateMedicalHistoryRecordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DuplicateMedicalHistoryRecordException() {
		
	}
	public DuplicateMedicalHistoryRecordException(String msg) {
		super(msg);
	}
	
}
