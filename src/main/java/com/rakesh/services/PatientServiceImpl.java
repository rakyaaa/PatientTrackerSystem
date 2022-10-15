package com.rakesh.services;
/**
-File Name          : PatientServiceImpl
-Author Name        : Rakesh
-Description        : Implements Patient Services 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.dao.PatientDAO;
import com.rakesh.entities.Patient;
import com.rakesh.model.*;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientDAO pdao;
	@Autowired
	MedicalHistoryService medser;
	@Autowired
	AppointmentService aptser;

	/*******************************************************************************
	 - Method Name      : addPatient
	 - Input Parameters : Patient p
	 - Return type      : Patient
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Inserting a patient into the database.
	  ******************************************************************************/
	@Override
	public Patient addPatient(Patient p) {
		pdao.saveAndFlush(p);
		return p;
	}
	
	/*******************************************************************************
	 - Method Name      : deletePatient
	 - Input Parameters : Integer id
	 - Return type      : void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting patient by Patient-id from the database.
	  ******************************************************************************/
	@Override
	public void deletePatient(int id) {
		medser.deleteByPatientId(id);
		aptser.deleteByPatientId(id);
		pdao.deleteById(id);
		
	}
	
	/*******************************************************************************
	 - Method Name      : viewAllPatient
	 - Input Parameters : 
	 - Return type      : Patients
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all patient from the database.
	  ******************************************************************************/
	@Override
	public Patients viewAllPatient() {
		return new Patients(pdao.findAll());
	}
	/*******************************************************************************
	 - Method Name      : viewPatientById
	 - Input Parameters : Integer id
	 - Return type      : patient
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a patient by Patient-id from the database.
	  ******************************************************************************/
	@Override
	public Patient viewPatientById(int id) {
		Optional<Patient> p = pdao.findById(id);
		return p.get();
	}
	
	/*******************************************************************************
	 - Method Name      : viewPatientByName
	 - Input Parameters : String name
	 - Return type      : Patients
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a patient by Patient-name from the database.
	  ******************************************************************************/
	@Override
	public Patients viewPatientByName(String name) {
		List<Patient> p = pdao.viewPatientByName(name);
		return new Patients(p);
	}
	
	/*******************************************************************************
	 - Method Name      : viewMedicalHistoryByPatientId
	 - Input Parameters : Integer id
	 - Return type      : MedicalHistories
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all Medical histories by Patient-Id from the database.
	  ******************************************************************************/
	@Override
	public MedicalHistories viewMedicalHistoryByPatientId(int id) {
		Patient p = pdao.getOne(id);
		return new MedicalHistories(p.getMedicalHistoryList());
	}
	
	/*******************************************************************************
	 - Method Name      : viewAppointmentByPatientId
	 - Input Parameters : Integer id
	 - Return type      : Appointments
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all Appointments by Patient-Id from the database.
	  ******************************************************************************/
	@Override
	public Appointments viewAppointmentByPatientId(int id) {
		Patient p = pdao.getOne(id);
		return new Appointments(p.getAppointmentList());
	}

}
