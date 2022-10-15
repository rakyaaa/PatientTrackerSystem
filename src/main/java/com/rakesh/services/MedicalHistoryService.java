package com.rakesh.services;

/**
-File Name          : MedicalHistoryService
-Author Name        : Rakesh
-Description        : MedicalHistory Service Interface 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import org.springframework.stereotype.Service;

import com.rakesh.entities.MedicalHistory;
import com.rakesh.model.MedicalHistories;

@Service
public interface MedicalHistoryService {

	public MedicalHistory addMedicalHistory(MedicalHistory m);
	public MedicalHistories viewAllMedicalHistory();
	public void deleteByPatientId(int id);
	public void deleteByDoctorId(int id);
	
}
