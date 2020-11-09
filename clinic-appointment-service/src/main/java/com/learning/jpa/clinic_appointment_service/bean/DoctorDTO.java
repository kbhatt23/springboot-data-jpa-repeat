package com.learning.jpa.clinic_appointment_service.bean;

import com.learning.jpa.clinic_appointment_service.entities.Doctor;
import com.learning.jpa.clinic_appointment_service.entities.Speciality;

public class DoctorDTO {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Speciality speciality;
	
	public DoctorDTO() {
		
	}
	public DoctorDTO(Doctor doctor) {
		this.id=doctor.getId();
		this.firstName=doctor.getNameBean().getFirstName();
		this.lastName=doctor.getNameBean().getLastName();
		this.speciality=doctor.getSpeciality();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	} 
	
	
}
