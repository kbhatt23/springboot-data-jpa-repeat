package com.learning.jpa.inheritance_mapping.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

//the columns will be put in user entity's table
@Embeddable
public class CompositeKeyV2  implements Serializable {

	private static final long serialVersionUID = 2370759982781620121L;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	public CompositeKeyV2() {
		
	}

	public CompositeKeyV2(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public CompositeKeyV2(CompositeCustomerDTO compositeCustomerDTO) {
		this.firstName = compositeCustomerDTO.getFirstName();
		this.lastName = compositeCustomerDTO.getLastName();
		this.email = compositeCustomerDTO.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "CompositeKeyV2 [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKeyV2 other = (CompositeKeyV2) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
}
