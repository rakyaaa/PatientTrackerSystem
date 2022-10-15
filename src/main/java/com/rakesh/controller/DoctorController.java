package com.rakesh.controller;
/**
-File Name          : DoctorController
-Author Name        : Rakesh
-Description        : Rest Controller for Services
-Creation Date		: 14/04/2021
-Last Modified Date : 14/04/2021
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.entities.Appointment;
import com.rakesh.entities.Doctor;
import com.rakesh.entities.MedicalHistory;
import com.rakesh.entities.Patient;
import com.rakesh.exceptions.DateFormatException;
import com.rakesh.exceptions.DoctorNotFoundException;
import com.rakesh.exceptions.DuplicateAppointmentRecordException;
import com.rakesh.exceptions.DuplicateDoctorException;
import com.rakesh.exceptions.DuplicateMedicalHistoryRecordException;
import com.rakesh.exceptions.DuplicatePatientException;
import com.rakesh.exceptions.PatientNotFoundException;
import com.rakesh.model.*;
import com.rakesh.services.AppointmentService;
import com.rakesh.services.DoctorService;
import com.rakesh.services.MedicalHistoryService;
import com.rakesh.services.PatientService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/doctor")
@Validated
@Api(tags= {"doctor-controller"})
public class DoctorController {

	@Autowired
	PatientService patientService;
	@Autowired
	MedicalHistoryService medicalHistoryService;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	DoctorService doctorService;
	
	Logger logger = LoggerFactory.getLogger(DoctorController.class);

	/*******************************************************************************
	 - Method Name      : addPatient
	 - Input Parameters : Patient p
	 - Return type      : Patient
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Inserting a patient into the database.
	  ******************************************************************************/
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient1) throws DuplicatePatientException {
		Patients patients = patientService.viewAllPatient();
		List<Patient> patientlist = patients.getPatients();
		boolean isPresent = false;
		for(Patient patient : patientlist) {
			if(patient.getId() == patient1.getId())
				isPresent = true;
		}
		if(!isPresent) {
			Patient patient =  patientService.addPatient(patient1);
			logger.info("Sucessfully Added the Patient with ID: " + patient1.getId() + " & Name: "+ patient1.getName());
			return patient;
		}else
			throw new DuplicatePatientException("Entered Primary Key for Patient Already exists.!");
		
	}
	
	/*******************************************************************************
	 - Method Name      : addMedicalHistory
	 - Input Parameters : MedicalHistory m
	 - Return type      : MedicalHistory
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Inserting a Medical History into the database.
	  ******************************************************************************/
	@PostMapping("/addMedicalHistory")
	public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory m) throws DateFormatException, DuplicateMedicalHistoryRecordException {
		String s = m.getDateOfVisit();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			sdf.parse(s);
			MedicalHistories mh3 = medicalHistoryService.viewAllMedicalHistory();
			List<MedicalHistory> mh2 = mh3.getMedicalHistories();
			boolean isPresent = false;
			for(MedicalHistory x : mh2) 
				if(x.getMedid() == m.getMedid())
					isPresent = true;
				if(!isPresent) {
					MedicalHistory m1= medicalHistoryService.addMedicalHistory(m);
					logger.info("Sucessfully added the Medical History");
					return m1;
				}else
					throw new DuplicateMedicalHistoryRecordException("Entered Primary Key for Medical History Already exists.!");
		} catch (ParseException e1) {
			logger.error("Failed to add Medical History because of wrong Date Format");
			throw new DateFormatException("Enter the Date in Valid Format (dd/mm/yyyy)");
		}
	}

	/*******************************************************************************
	 - Method Name      : addAppointment
	 - Input Parameters : Appointment a
	 - Return type      : Appointment
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Inserting an Appointment into  the database.
	  ******************************************************************************/
	@PostMapping("/addAppointment")
	public Appointment addAppointments(@RequestBody Appointment a) throws DateFormatException, DuplicateAppointmentRecordException {
		String s = a.getDateOfApt();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			sdf.parse(s);
			Appointments mh2 = appointmentService.viewAllAppointments();
			List<Appointment> mh3 = mh2.getAppointments();
			boolean isPresent = false;
			for(Appointment x : mh3) 
				if(x.getAptId() == a.getAptId())
					isPresent = true;
				if(!isPresent) {
					Appointment a1 = appointmentService.addAppointment(a);
					logger.info("Sucessfully Booked an Appointment");
					return a1;
				}else
					throw new DuplicateAppointmentRecordException("Entered Primary Key for Appointment Already exists.!");	
		} catch (ParseException e1) {
			logger.error("Failed to Book an Appointment because of wrong Date Format");
			throw new DateFormatException("Enter the Date in Valid Format (dd/mm/yyyy)");
		}
	}

	/*******************************************************************************
	 - Method Name      : addDoctor
	 - Input Parameters : Doctor d
	 - Return type      : Doctor
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Inserting a Doctor into the database.
	  ******************************************************************************/
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor d) throws DuplicateDoctorException {
		Doctors d3 = doctorService.viewAllDoctor();
		List<Doctor> p2 = d3.getDoctors();
		boolean isPresent = false;
		for(Doctor x : p2) {
			if(x.getId() == d.getId())
				isPresent = true;
		}
		if(!isPresent) {
			Doctor d1 = doctorService.addDoctor(d);
			logger.info("Sucessfully Added the Doctor with ID: " + d.getId() + " & Name: "+ d.getName());
			return d1;
		}else
			throw new DuplicateDoctorException("Entered Primary Key for Doctor Already exists.!");	
	}

	/*******************************************************************************
	 - Method Name      : deletePatient
	 - Input Parameters : Integer id
	 - Return type      : void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting patient by Patient-id from the database.
	  ******************************************************************************/
	@DeleteMapping("/deletePatient/{id}")
	public void detetePatient(@PathVariable int id) throws PatientNotFoundException {
		try {
			patientService.deletePatient(id);
			logger.info("Sucessfully Deleted the Patient with Patient ID: " + id);
		} catch (Exception exp) {
			throw new PatientNotFoundException(
					"Please enter Valid Patient ID, Given Patient Id: " + id + " not found in record");
		}
	}

	/*******************************************************************************
	 - Method Name      : deleteDoctor
	 - Input Parameters : Integer id
	 - Return type      : Void
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Deleting a Doctor from the database.
	  ******************************************************************************/
	@DeleteMapping("/deleteDoctor/{id}")
	public void deteteDoctor(@PathVariable int id) throws DoctorNotFoundException {
		try {
			doctorService.deleteDoctor(id);
			logger.info("Sucessfully Deleted the Doctor with Doctor ID: " + id);
		} catch (Exception exp) {
			throw new DoctorNotFoundException(
					"Please enter Valid Doctor ID, Given Doctor Id: " + id + " not found in record");
		}
	}

	/*******************************************************************************
	 - Method Name      : getAllMedicalHistory
	 - Input Parameters : 
	 - Return type      : MedicalHistories
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all medical histories from the database.
	  ******************************************************************************/
	@GetMapping("/getAllMedicalHistory")
	public MedicalHistories getAllMedicalHistory() {
		logger.info("Sucessfully fetched the full Medical History");
		return medicalHistoryService.viewAllMedicalHistory();
	}

	/*******************************************************************************
	 - Method Name      : getAllPatient
	 - Input Parameters : 
	 - Return type      : Patients
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all patient from the database.
	  ******************************************************************************/
	@GetMapping("/getAllPatient")
	public Patients getAllPatient() {
		logger.info("Sucessfully fetched the full Patient List");
		return patientService.viewAllPatient();
	}

	/*******************************************************************************
	 - Method Name      : getAllAppointments
	 - Input Parameters : 
	 - Return type      : Appointments
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all Appointments from  the database.
	  ******************************************************************************/ 
	@GetMapping("/getAllAppointment")
	public Appointments getAllAppointments() {
		logger.info("Sucessfully fetched the full Appointment List");
		return appointmentService.viewAllAppointments();
	}

	/*******************************************************************************
	 - Method Name      : getAllDoctor
	 - Input Parameters :
	 - Return type      : Doctors
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all Doctors from the database.
	  ******************************************************************************/
	@GetMapping("/getAllDoctor")
	public Doctors getAllDoctor() {
		logger.info("Sucessfully fetched the full Doctor List");
		return doctorService.viewAllDoctor();
	}

	/*******************************************************************************
	 - Method Name      : getPatientById
	 - Input Parameters : Integer id
	 - Return type      : patient
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a patient by Patient-id from the database.
	  ******************************************************************************/
	@GetMapping("/getPatientById/{id}")
	public Patient getPatientById(@PathVariable int id) throws PatientNotFoundException {
		try {
			Patient p = patientService.viewPatientById(id);
			logger.info("Sucessfully fetched the Patient with Patient ID: "+ id);
			return p;
		} catch (Exception exp) {
			throw new PatientNotFoundException(
					"Please enter Valid Patient ID, Given Patient Id: " + id + " not found in record");
		}
	}

	/*******************************************************************************
	 - Method Name      : getDoctorById
	 - Input Parameters : Integer id
	 - Return type      : Doctor
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a Doctor by id from the database.
	  ******************************************************************************/
	@GetMapping("/getDoctorById/{id}")
	public Doctor getDoctorById(@PathVariable int id) throws DoctorNotFoundException {
		try {
			Doctor d = doctorService.viewDoctorById(id);
			logger.info("Sucessfully fetched the Doctor with Doctor ID: "+ id);
			return d;
		} catch (Exception exp) {
			throw new DoctorNotFoundException(
					"Please enter Valid Doctor ID, Given Doctor Id: " + id + " not found in record");
		}

	}

	/*******************************************************************************
	 - Method Name      : getAllMedicalHistory
	 - Input Parameters : 
	 - Return type      : MedicalHistories
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all medical histories from the database.
	  ******************************************************************************/
	@GetMapping("/getAllMedicalHistoryByPatientId/{id}")
	public MedicalHistories viewMedicalHistoryByPatientId(@PathVariable int id) throws PatientNotFoundException {
		try {
			MedicalHistories mh3 = patientService.viewMedicalHistoryByPatientId(id);
			logger.info("Sucessfully fetched the Medical History for Patient ID: "+ id);
			return mh3;
		} catch (Exception exp) {
			throw new PatientNotFoundException(
					"Please enter Valid Patient ID, Given Patient Id: " + id + " not found in record");
		}
	}

	/*******************************************************************************
	 - Method Name      : getAllTreatedPatientByDoctorId
	 - Input Parameters : Integer id
	 - Return type      : MedicalHistories
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving a treated patient list by Doctor-id from the database.
	  ******************************************************************************/
	@GetMapping("/getAllTreatedPatientByDoctorId/{id}")
	public MedicalHistories getAllTeatedPatientByDoctorId(@PathVariable int id) throws DoctorNotFoundException {
		try {
			
			MedicalHistories t =  doctorService.viewTreatedPatientByDoctorId(id);
			logger.info("Sucessfully fetched the Treated Patient History  for Doctor ID: "+ id);
			return t;
		} catch (Exception exp) {
			throw new DoctorNotFoundException(
					"Please enter Valid Doctor ID, Given Doctor Id: " + id + " not found in record");
		}
	}

	/*******************************************************************************
	 - Method Name      : getAppointmentByPatientId
	 - Input Parameters : Integer id
	 - Return type      : Appointments
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all appointments by Patient-id from the database.
	  ******************************************************************************/
	@GetMapping("/getAllAppointmentListByPatientId/{id}")
	public Appointments viewAppointmentByPatientId(@PathVariable int id) throws PatientNotFoundException {
		try {
			Appointments a = patientService.viewAppointmentByPatientId(id);
			logger.info("Sucessfully fetched the Appointments for Patient ID: "+ id);
			return a;
		} catch (Exception exp) {
			throw new PatientNotFoundException(
					"Please enter Valid Patient ID, Given Patient Id: " + id + " not found in record");
		}
	}

	/*******************************************************************************
	 - Method Name      : getAppointmentByDoctorId
	 - Input Parameters : Integer id
	 - Return type      : Appointments
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all appointments by Doctor-id from the database.
	  ******************************************************************************/
	@GetMapping("/getAllAppointmentListByDoctorId/{id}")
	public Appointments viewAppointmentByDoctorId(@PathVariable int id) throws DoctorNotFoundException {
		try {
			Appointments a = doctorService.viewAppointmentByDoctorId(id);
			logger.info("Sucessfully fetched the Appointments for Doctor ID: "+ id);
			return a;
		} catch (Exception exp) {
			throw new DoctorNotFoundException(
					"Please enter Valid Doctor ID, Given Doctor Id: " + id + " not found in record");
		}
	}

	/*******************************************************************************
	 - Method Name      : viewPatientByName
	 - Input Parameters : String name
	 - Return type      : Patients
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all patients by patient-name from the database.
	  ******************************************************************************/
	@GetMapping("/getPatientByName/{name}")
	public Patients viewPatientByName(@PathVariable String name) throws PatientNotFoundException {
		Patients p1 = patientService.viewPatientByName(name);
		List<Patient> p= p1.getPatients();
		if(p.size()>0) {
			logger.info("Sucessfully fetched the Patient with Patient Name: "+ name);
			return p1;
		}else
			throw new PatientNotFoundException("Please enter Valid Patient Name, Given Patient Name: " + name + " not found in record");

	}

	/*******************************************************************************
	 - Method Name      : viewDoctorByDegree
	 - Input Parameters : String degree
	 - Return type      : Appointments
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all doctors by degree from the database.
	  ******************************************************************************/
	@GetMapping("/viewDoctorByDegree/{degree}")
	public Doctors viewDoctorByDegree(@PathVariable String degree) throws DoctorNotFoundException {
		Doctors d1 = doctorService.viewDoctorByDegree(degree);
		List<Doctor> d = d1.getDoctors();
		if(d.size()>0) {
			logger.info("Sucessfully fetched the Doctor with Degree: "+ degree);
			return d1;
		}
		else
			throw new DoctorNotFoundException(
					"Please enter Valid Doctor Degree, Given Doctor Degree: " + degree + " not found in record");
		
	}

	/*******************************************************************************
	 - Method Name      : viewDoctorsBySpeciality
	 - Input Parameters : String Speciality
	 - Return type      : Doctors
	 - Author           : Rakesh
	 - Creation Date    : 12/04/2021
	 - Description      : Retrieving all Doctors by Speciality from the database.
	  ******************************************************************************/
	@GetMapping("/viewDoctorBySpeciality/{speciality}")
	public Doctors viewDoctorBySpeciality(@PathVariable String speciality) throws DoctorNotFoundException {
		Doctors d1 = doctorService.viewDoctorBySpeciality(speciality);
		List<Doctor> d = d1.getDoctors();
		if(d.size()>0) {
			logger.info("Sucessfully fetched the Doctor with Degree: "+ speciality);
			return d1;
		}
		else
			throw new DoctorNotFoundException("Please enter Valid Doctor speciality, Given Doctor speciality: "
					+ speciality + " not found in record");
	}
}
