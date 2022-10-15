package com.rakesh.services;
/**
-File Name          : AppointmentService
-Author Name        : Rakesh
-Description        : Appointment Service Interface 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/

import org.springframework.stereotype.Service;

import com.rakesh.entities.Appointment;
import com.rakesh.model.Appointments;

@Service
public interface AppointmentService {

	public Appointment addAppointment(Appointment a);
	public Appointments viewAllAppointments();
	public void deleteByPatientId(int id);
	public void deleteByDoctorId(int id);
}
