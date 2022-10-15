package com.rakesh.dao;
/**
-File Name          : AppointmentDao
-Author Name        : Rakesh
-Description        : Repository for Appointment Entity
-Creation Date		: 13/04/2021
-Last Modified Date : 13/04/2021
*/
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rakesh.entities.Appointment;

@Repository("appointments")
public interface AppointmentDAO extends	JpaRepository<Appointment, Integer>{
	/*******************************************************************************
	 - Method Name      : deleteByPatientId
	 - Input Parameters : Integer paId
	 - Return type      : void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting appointment by Patient-id from the database.
	  ******************************************************************************/ 
	@Transactional
	@Modifying
	@Query("DELETE FROM Appointment m WHERE m.patientId = ?1")
	public void deleteByPatientId(int paId);
	
	/*******************************************************************************
	 - Method Name      : deleteByDoctor
	 - Input Parameters : Integer doId
	 - Return type      : void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting appointment by Doctor-id from  the database.
	  ******************************************************************************/ 
	@Transactional
	@Modifying
	@Query("DELETE FROM Appointment m WHERE m.doctorId = ?1")
	public void deleteByDoctorId(int doId);

}
