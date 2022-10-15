package com.rakesh.dao;
/**
-File Name          : DoctorDao
-Author Name        : Rakesh
-Description        : Repository for Doctor Entity
-Creation Date		: 13/04/2021
-Last Modified Date : 13/04/2021
*/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rakesh.entities.Doctor;

@Repository("doctor")
public interface DoctorDAO extends JpaRepository<Doctor, Integer>{
	
	/*******************************************************************************
	 - Method Name      : viewDoctorByDegree
	 - Input Parameters : String degree
	 - Return type      : List<Doctors>
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a Doctor by degree from the database.
	  ******************************************************************************/ 
	@Query("SELECT d FROM Doctor d WHERE LOWER(d.degree) = LOWER(?1)")
	public List<Doctor> viewDoctorByDegree(String degree);
	
	/*******************************************************************************
	 - Method Name      : viewDoctorBySpecialist
	 - Input Parameters : String Speciality
	 - Return type      : Appointment
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a doctor by speciality from the database.
	  ******************************************************************************/ 
	@Query("SELECT d FROM Doctor d WHERE LOWER(d.speciality) = LOWER(?1)")
	public List<Doctor> viewDoctorBySpecialist(String Speciality);
	
}
