package com.learning.jpa.inheritance_mapping.entities.products;

import javax.persistence.Entity;

@Entity
public class PreemiumProductTablePerClass extends ProductTablePerClass{

	private String preemiumNumber;
	
	private String preemiumMessage;

	public String getPreemiumNumber() {
		return preemiumNumber;
	}

	public void setPreemiumNumber(String preemiumNumber) {
		this.preemiumNumber = preemiumNumber;
	}

	public String getPreemiumMessage() {
		return preemiumMessage;
	}

	public void setPreemiumMessage(String preemiumMessage) {
		this.preemiumMessage = preemiumMessage;
	}

}
