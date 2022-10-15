package com.rakesh.dao;
/**
-File Name          : MedicalHistoryDao
-Author Name        : Rakesh
-Description        : Repository for MedicalHistory Entity
-Creation Date		: 13/04/2021
-Last Modified Date : 13/04/2021
*/
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rakesh.entities.MedicalHistory;

@Repository("medicalhistory")
public interface MedicalHistoryDAO extends JpaRepository<MedicalHistory, Integer> {
	/*******************************************************************************
	 - Method Name      : deleteByPatientId
	 - Input Parameters : Integer id
	 - Return type      : void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting Medical history by Patient-id from the database.
	  ******************************************************************************/ 
	@Transactional
	@Modifying
	@Query("DELETE FROM MedicalHistory m WHERE m.patientId = ?1")
	public void deleteByPatientId(int id);
	@Transactional
	
	/*******************************************************************************
	 - Method Name      : deleteByDoctortId
	 - Input Parameters : Integer id
	 - Return type      : void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting Medical history by Doctor-id from the database.
	  ******************************************************************************/ 

	@Modifying
	@Query("DELETE FROM MedicalHistory m WHERE m.doctorId = ?1")
	public void deleteByDoctorId(int id);
}
