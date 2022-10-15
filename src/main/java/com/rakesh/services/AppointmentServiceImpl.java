package com.rakesh.services;

/**
    -File Name          : AppointmentServiceImpl
    -Author Name        : Rakesh
    -Description        : Implements Appointment Services 
    -Creation Date		: 12/04/2021
    -Last Modified Date : 12/04/2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.dao.AppointmentDAO;
import com.rakesh.entities.Appointment;
import com.rakesh.model.Appointments;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDAO adao;
	
	/*******************************************************************************
	 - Method Name      : addAppointment
	 - Input Parameters : Appointment a
	 - Return type      : Appointment
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Inserting an Appointment into  the database.
	  ******************************************************************************/ 

	@Override
	public Appointment addAppointment(Appointment a) {
		adao.saveAndFlush(a);
		return a;
	}

	/*******************************************************************************
	 - Method Name      : viewAllAppointments
	 - Input Parameters : 
	 - Return type      : Appointments
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all Appointments from  the database.
	  ******************************************************************************/ 
	@Override
	public Appointments viewAllAppointments() {
		return new Appointments(adao.findAll());
			
	}
	/********************************************************************************
	 - Method Name      : deleteByPatientId
	 - Input Parameters : Integer id
	 - Return type      : Void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting a Appointment by patient-id from the database.
	                     
	  ******************************************************************************/ 

	@Override
	public void deleteByPatientId(int id) {
		adao.deleteByPatientId(id);
	}
	
	/*******************************************************************************
	 - Method Name      : deleteByDoctorId
	 - Input Parameters : Integer id
	 - Return type      : Void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting a Appointment by doctor-ID from the database.
	  ******************************************************************************/ 

	@Override
	public void deleteByDoctorId(int id) {
		adao.deleteByDoctorId(id);
	}

}
