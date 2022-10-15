package com.rakesh.entities;
/**
-File Name          : Patient
-Author Name        : Rakesh
-Description        : Patient Entity POJO 
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "Patient.viewPatientByName" , query = "SELECT p FROM Patient p WHERE LOWER(p.name) = LOWER(?1)")
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@NotBlank(message = "Patient name cannot be Blank")
	@Size(min = 2,max = 20 , message = "Name should contain characters between 2 to 20")
	private String name;
	@NotNull(message = "Age cannot be Blank")
	private int age;
	@NotBlank(message = "Gender cannot be Blank")
	@Size(min = 2,max = 20 , message = "Gender should contain characters between 2 to 20")
	private String gender;
	@Email
	@NotBlank(message = "Email cannot be Blank")
	@Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,4}", message = "Enter valid Email Id")
	private String email;
	@NotNull(message = "Phone Number cannot be Blank")
	private long phone;
	@NotBlank(message = "Blood Group cannot be Blank")
	@Size(min = 2,max = 20 , message = "Blood Group should contain characters between 2 to 20")
	private String bloodGrp;
	@NotBlank(message = "AddressLine1 cannot be Blank")
	@Size(min = 2,max = 20 , message = "AddressLine1 should contain characters between 2 to 20")
	private String addressLine1;
	@NotBlank(message = "Locality cannot be Blank")
	@Size(min = 2,max = 20 , message = "Locality should contain characters between 2 to 20")
	private String locality;
	@NotBlank(message = "City cannot be Blank")
	@Size(min = 2,max = 20 , message = "City should contain characters between 2 to 20")
	private String city;
	@NotNull(message = "Pin Code cannot be Blank")
	private long pincode;
	
	@OneToMany(targetEntity = MedicalHistory.class , cascade = CascadeType.ALL )
	@JoinColumn(name = "patientId", referencedColumnName = "id")
	private List<MedicalHistory> medicalHistoryList;
	
	@OneToMany(targetEntity = Appointment.class , cascade = CascadeType.ALL  )
	@JoinColumn(name = "patientId", referencedColumnName = "id")
	private List<Appointment> appointmentList;

	public Patient() {
		
	}
	
	public Patient(int id,
			@NotBlank(message = "Patient name cannot be Blank") @Size(min = 2, max = 20, message = "Name should contain characters between 2 to 20") String name,
			@NotNull(message = "Age cannot be Blank") int age,
			@NotBlank(message = "Gender cannot be Blank") String gender,
			@Email @NotBlank(message = "Email cannot be Blank") @Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,4}", message = "Enter valid Email Id") String email,
			@NotNull(message = "Phone Number cannot be Blank") long phone,
			@NotBlank(message = "Blood Group cannot be Blank") String bloodGrp,
			@NotBlank(message = "AddressLine1 cannot be Blank") String addressLine1,
			@NotBlank(message = "Locality cannot be Blank") String locality,
			@NotBlank(message = "City cannot be Blank") String city,
			@NotNull(message = "Pin Code cannot be Blank") long pincode, List<MedicalHistory> medicalHistoryList,
			List<Appointment> appointmentList) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.bloodGrp = bloodGrp;
		this.addressLine1 = addressLine1;
		this.locality = locality;
		this.city = city;
		this.pincode = pincode;
		this.medicalHistoryList = medicalHistoryList;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getBloodGrp() {
		return bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public List<MedicalHistory> getMedicalHistoryList() {
		return medicalHistoryList;
	}

	public void setMedicalHistoryList(List<MedicalHistory> medicalHistoryList) {
		this.medicalHistoryList = medicalHistoryList;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email
				+ ", phone=" + phone + ", bloodGrp=" + bloodGrp + ", addressLine1=" + addressLine1 + ", locality="
				+ locality + ", city=" + city + ", pincode=" + pincode + ", medicalHistoryList=" + medicalHistoryList
				+ ", appointmentList=" + appointmentList + "]";
	}
	
}
