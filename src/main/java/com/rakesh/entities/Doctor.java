package com.rakesh.entities;
/**
-File Name          : Doctor
-Author Name        : Rakesh
-Description        : Doctor Entity POJO 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@NotBlank(message = "Doctor name cannot be Blank")
	@Size(min = 2,max = 20 , message = "Name should contain characters between 2 to 20")
	private String name;
	@NotBlank(message = "Degree cannot be Blank")
	@Size(min = 2,max = 20 , message = "Degree should contain characters between 2 to 20")
	private String degree;
	@NotBlank(message = "Speciality cannot be Blank")
	@Size(min = 2,max = 20 , message = "Speciality should contain characters between 2 to 20")
	private String speciality;
	@Email
	@NotBlank(message = "Email cannot be Blank")
	@Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,4}", message = "Enter valid Email Id")
	private String email;
	@NotNull(message = "Experience cannot be Blank")
	private int exp;
	
	@OneToMany(targetEntity = MedicalHistory.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId", referencedColumnName = "id")
	private List<MedicalHistory> treatedPatientList;
	
	@OneToMany(targetEntity = Appointment.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId", referencedColumnName = "id")
	private List<Appointment> appointmentList;
	
	public Doctor() {
		
	}

	public Doctor(int id,
			@NotBlank(message = "Doctor name cannot be Blank") @Size(min = 2, max = 20, message = "Name should contain characters between 2 to 20") String name,
			@NotBlank(message = "Degree cannot be Blank") @Size(min = 2, max = 20, message = "Degree should contain characters between 2 to 20") String degree,
			@NotBlank(message = "Speciality cannot be Blank") @Size(min = 2, max = 20, message = "Speciality should contain characters between 2 to 20") String speciality,
			@Email @NotBlank(message = "Email cannot be Blank") @Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,4}", message = "Enter valid Email Id") String email,
			@NotNull(message = "Experience cannot be Blank") int exp, List<MedicalHistory> treatedPatientList,
			List<Appointment> appointmentList) {
		super();
		this.id = id;
		this.name = name;
		this.degree = degree;
		this.speciality = speciality;
		this.email = email;
		this.exp = exp;
		this.treatedPatientList = treatedPatientList;
		this.appointmentList = appointmentList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public List<MedicalHistory> getTreatedPatientList() {
		return treatedPatientList;
	}

	public void setTreatedPatientList(List<MedicalHistory> treatedPatientList) {
		this.treatedPatientList = treatedPatientList;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", degree=" + degree + ", speciality=" + speciality + ", email="
				+ email + ", exp=" + exp + ", treatedPatientList=" + treatedPatientList + ", appointmentList="
				+ appointmentList + "]";
	}

	
}
