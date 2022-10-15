package com.rakesh.exceptions;
/**
-File Name          : GlobalExceptionHandler
-Author Name        : Rakesh
-Description        : GlobalExceptionHandler 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.sql.SQLException;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(PatientNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handelPatNotFoundException(PatientNotFoundException e , HttpServletRequest request) {
		logger.error("Patient not found with the given ID. Error info: " + e.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(DuplicatePatientException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo handeldupPatFoundException(DuplicatePatientException e , HttpServletRequest request) {
		logger.error("Patient with given Patient ID already exists. Error info: " + e.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(DuplicateDoctorException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo handeldupDocFoundException(DuplicateDoctorException e , HttpServletRequest request) {
		logger.error("Doctor with given Doctor ID already exists. Error info: " + e.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(DuplicateMedicalHistoryRecordException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo handeldupMHFoundException(DuplicateMedicalHistoryRecordException e , HttpServletRequest request) {
		logger.error("Medical History with given Medical History ID already exists. Error info: " + e.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(DuplicateAppointmentRecordException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo handeldupAppFoundException(DuplicateAppointmentRecordException e , HttpServletRequest request) {
		logger.error("Appointment with given Appointment ID already exists. Error info: " + e.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(DateFormatException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handelDateFormatException(DateFormatException e , HttpServletRequest request) {
		logger.error("DateFormatException (user defined exception) has occured because of wrong date format. Error info: " + e.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(DoctorNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handelDocNotFoundException(DoctorNotFoundException e , HttpServletRequest request) {
		logger.error("Doctor not found with the given ID. Error info: " + e.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e){
		logger.error("ConstraintViolationException has occured. Error info: " + e.getMessage());
		return new ResponseEntity<>("Validation error on path variable  " + e.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST )
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
		logger.error("NoSuchElementException has occured. Error info: " + e.getMessage());
		return new ResponseEntity<>("No Such element present  " + e.getMessage() , HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(SQLException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorInfo handleEntityNotFoundException(SQLException e , HttpServletRequest request) {
		logger.error("Foreign key Voilation has occured. Error info: " + e.getMessage());
		System.err.println(e.getMessage());
		System.err.println(e.getErrorCode());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(e.getMessage());
		error.setUrl(request.getRequestURI());
		return error;
		
	}	
}
