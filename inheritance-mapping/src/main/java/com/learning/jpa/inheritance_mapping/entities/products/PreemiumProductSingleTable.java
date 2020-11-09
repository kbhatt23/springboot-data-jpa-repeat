package com.learning.jpa.inheritance_mapping.entities.products;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "preemium")
public class PreemiumProductSingleTable extends ProductSingleTable{

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
