package com.rakesh.entities;
/**
-File Name          : MedicalHistory
-Author Name        : Rakesh
-Description        : MedicalHistory Entity POJO 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class MedicalHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int medid;
	@NotBlank(message = "Diagnosis of Appointment cannot be Blank")
	@Size(min = 2,max = 20 , message = "Diagnosis should contain characters between 2 to 20")
	private String diagnosis;
	@NotBlank(message = "Treatment of Appointment cannot be Blank")
	@Size(min = 2,max = 20 , message = "Treatment should contain characters between 2 to 20")
	private String treatment;
	@DecimalMin("1")
	private int cost;
	@DecimalMin("1")
	private int patientId;
	@DecimalMin("1")
	private int doctorId;
	@NotBlank(message = "Date of Visit cannot be Blank")
	private String dateOfVisit;
	
	public MedicalHistory() {
		
	}

	public int getMedid() {
		return medid;
	}

	public void setMedid(int medid) {
		this.medid = medid;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public MedicalHistory(int medid,
			@NotBlank(message = "Diagnosis of Appointment cannot be Blank") @Size(min = 2, max = 20, message = "Diagnosis should contain characters between 2 to 20") String diagnosis,
			@NotBlank(message = "Treatment of Appointment cannot be Blank") @Size(min = 2, max = 20, message = "Treatment should contain characters between 2 to 20") String treatment,
			@DecimalMin("1") int cost, @DecimalMin("1") int patientId, @DecimalMin("1") int doctorId,
			@NotBlank(message = "Date of Visit cannot be Blank") String dateOfVisit) {
		super();
		this.medid = medid;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.cost = cost;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.dateOfVisit = dateOfVisit;
	}

	@Override
	public String toString() {
		return "MedicalHistory [medid=" + medid + ", diagnosis=" + diagnosis + ", treatment=" + treatment + ", cost="
				+ cost + ", patientId=" + patientId + ", doctorId=" + doctorId + ", dateOfVisit=" + dateOfVisit + "]";
	}


	
}
