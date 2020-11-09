package com.learning.jpa.inheritance_mapping.entities.products;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
//no nee to create table for single table strategy for subclasses
@Entity
//put column name of primary key of super class
@PrimaryKeyJoinColumn(name = "id")
public class FreemiumProductJoined extends ProductJoined{

	private String freemiumNumber;
	
	private String freemiumMessage;

	public String getFreemiumNumber() {
		return freemiumNumber;
	}

	public void setFreemiumNumber(String freemiumNumber) {
		this.freemiumNumber = freemiumNumber;
	}

	public String getFreemiumMessage() {
		return freemiumMessage;
	}

	public void setFreemiumMessage(String freemiumMessage) {
		this.freemiumMessage = freemiumMessage;
	}
	
	
}
