package com.rakesh.model;
/**
-File Name          : Patients
-Author Name        : Rakesh
-Description        : Patient Model class 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.util.List;

import com.rakesh.entities.*;
public class Patients {

	private List<Patient> patients;

	public Patients() {
		
	}
	
	public Patients(List<Patient> patients) {
		super();
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Patients [patients=" + patients + "]";
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
}
