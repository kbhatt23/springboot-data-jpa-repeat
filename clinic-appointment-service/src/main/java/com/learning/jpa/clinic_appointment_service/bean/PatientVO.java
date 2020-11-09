package com.learning.jpa.clinic_appointment_service.bean;

import com.learning.jpa.clinic_appointment_service.entities.Patient;

public class PatientVO {
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	

	public PatientVO(Patient patient) {
		this.id=patient.getId();
		this.firstName=patient.getNameBean().getFirstName();
		this.lastName=patient.getNameBean().getLastName();
	}

	public PatientVO() {
		super();
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
	
	
	

}
