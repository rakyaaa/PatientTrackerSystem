package com.rakesh.services;
/**
-File Name          : DoctorService
-Author Name        : Rakesh
-Description        : Doctor Service Interface 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import org.springframework.stereotype.Service;

import com.rakesh.entities.*;
import com.rakesh.model.*;

@Service
public interface DoctorService {

	public Doctor addDoctor(Doctor d);
	public void deleteDoctor(int id);
	public Doctors viewAllDoctor();
	public Doctor viewDoctorById(int id);
	public Doctors viewDoctorByDegree(String degree);
	public Doctors viewDoctorBySpeciality(String specialist);
	public MedicalHistories viewTreatedPatientByDoctorId(int id);
	public Appointments viewAppointmentByDoctorId(int id);
	
}
