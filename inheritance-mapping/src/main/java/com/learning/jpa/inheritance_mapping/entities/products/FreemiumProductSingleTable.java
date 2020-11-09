package com.learning.jpa.inheritance_mapping.entities.products;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//no nee to create table for single table strategy for subclasses
@Entity
@DiscriminatorValue(value = "freemium")
public class FreemiumProductSingleTable extends ProductSingleTable{

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
