package com.rakesh.services;
/**
-File Name          : DoctorServiceImpl
-Author Name        : Rakesh
-Description        : Implements Doctor Services 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.dao.DoctorDAO;
import com.rakesh.entities.*;
import com.rakesh.model.*;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorDAO ddao;
	@Autowired
	MedicalHistoryService medser;
	@Autowired
	AppointmentService aptser;
	
	/*******************************************************************************
	 - Method Name      : addDoctor
	 - Input Parameters : Doctor d
	 - Return type      : Doctor
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Inserting a Doctor into the database.
	  ******************************************************************************/ 
	@Override
	public Doctor addDoctor(Doctor d) {
		ddao.saveAndFlush(d);
		return d;
	}
	
	/*******************************************************************************
	 - Method Name      : deleteDoctor
	 - Input Parameters : Integer id
	 - Return type      : Void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting a Doctor from the database.
	  ******************************************************************************/
	@Override
	public void deleteDoctor(int id) {
		medser.deleteByDoctorId(id);
		aptser.deleteByDoctorId(id);
		ddao.deleteById(id);
	}
	
	/*******************************************************************************
	 - Method Name      : viewAllDoctor
	 - Input Parameters :
	 - Return type      : Doctors
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all Doctors from the database.
	  ******************************************************************************/
	@Override
	public Doctors viewAllDoctor() {
		return new Doctors(ddao.findAll());
	}
	
	/*******************************************************************************
	 - Method Name      : viewDoctorById
	 - Input Parameters : Integer id
	 - Return type      : Doctor
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a Doctor by id from the database.
	  ******************************************************************************/
	@Override
	public Doctor viewDoctorById(int id) {
		Optional<Doctor> d = ddao.findById(id);
		return d.get();
	}
	
	/*******************************************************************************
	 - Method Name      : viewDoctorByDegree
	 - Input Parameters : String degree
	 - Return type      : Doctors
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a Doctor by degree from the database.
	  ******************************************************************************/
	@Override
	public Doctors viewDoctorByDegree(String degree) {
		return new Doctors(ddao.viewDoctorByDegree(degree));
	}
	
	/*******************************************************************************
	 - Method Name      : viewDoctorBySpeciality
	 - Input Parameters : String specialist
	 - Return type      : Doctors
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a Doctor by speciality from the database.
	  ******************************************************************************/
	@Override
	public Doctors viewDoctorBySpeciality(String specialist) {
		return new Doctors(ddao.viewDoctorBySpecialist(specialist));
	}
	
	/*******************************************************************************
	 - Method Name      : viewTreatedPatientByDoctorId
	 - Input Parameters : Integer id
	 - Return type      : MedicalHistories
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a treated patient list by Doctor-id from the database.
	  ******************************************************************************/
	@Override
	public MedicalHistories viewTreatedPatientByDoctorId(int id) {
		Doctor d = ddao.getOne(id);
		return new MedicalHistories(d.getTreatedPatientList());
	}
	
	/*******************************************************************************
	 - Method Name      : viewAppointmentByDoctorId
	 - Input Parameters : Integer id
	 - Return type      : Appointments
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving an appointments by Doctor-id from the database.
	  ******************************************************************************/
	@Override
	public Appointments viewAppointmentByDoctorId(int id) {
		Doctor d = ddao.getOne(id);
		return new Appointments(d.getAppointmentList());
	}



}
