package com.rakesh.entities;
/**
-File Name          : Appointment
-Author Name        : Rakesh
-Description        : Appointment Entity POJO 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;


@Entity
public class Appointment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int aptId;
	
	@DecimalMin("1")
	private int patientId;
	
	@DecimalMin("1")
	private int doctorId;
	
	@NotBlank(message = "Date of Appointment cannot be Blank")
	private String dateOfApt;
	
	public Appointment() {
		
	}

	public Appointment(int aptId, @DecimalMin("1") int patientId, @DecimalMin("1") int doctorId,
			@NotBlank(message = "Date of Appointment cannot be Blank") String dateOfApt) {
		super();
		this.aptId = aptId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.dateOfApt = dateOfApt;
	}

	public int getAptId() {
		return aptId;
	}

	public void setAptId(int aptId) {
		this.aptId = aptId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDateOfApt() {
		return dateOfApt;
	}

	public void setDateOfApt(String dateOfApt) {
		this.dateOfApt = dateOfApt;
	}

	@Override
	public String toString() {
		return "Appointment [aptId=" + aptId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", dateOfApt="
				+ dateOfApt + "]";
	}

	
}
