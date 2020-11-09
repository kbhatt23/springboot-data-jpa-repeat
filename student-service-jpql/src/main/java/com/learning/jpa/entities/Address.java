package com.learning.jpa.entities;
//an embedable entity do not have independent table
// and embedable entity will push all its columns to the class that uses it
// once a class uses @emebded annotiuon on a field (has a relation ship) m all columns are pushed to table of main entity
// an embedable entity need not to have primary key as it is not an indepedent table unlike one to one mapping

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	//added just for demonstration
	@Column(name = "address1")
	private String address1;
	
	private String state;
	
	private String country;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 
	
	
}
