package com.learning.jpa.clinic_appointment_service.entities;

import javax.persistence.Embeddable;

//columns will be pushed to table of entity that injects it
@Embeddable
public class EmbedableNameBean {

	private String firstName;
	
	private String lastName;
	
	

	public EmbedableNameBean() {
		super();
	}

	public EmbedableNameBean(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
