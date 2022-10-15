package com.rakesh.services;
/**
-File Name          : PatientService
-Author Name        : Rakesh
-Description        : Patient Service Interface 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import org.springframework.stereotype.Service;

import com.rakesh.entities.Patient;
import com.rakesh.model.*;

@Service
public interface PatientService {

	public Patient addPatient(Patient p);
	public void deletePatient(int id);
	public Patients viewAllPatient();
	public Patient viewPatientById(int id);
	public Patients viewPatientByName(String name);
	public MedicalHistories viewMedicalHistoryByPatientId(int id);
	public Appointments viewAppointmentByPatientId(int id);
}
