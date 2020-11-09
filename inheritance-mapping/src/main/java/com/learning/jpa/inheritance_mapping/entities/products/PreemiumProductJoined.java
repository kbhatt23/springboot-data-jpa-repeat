package com.learning.jpa.inheritance_mapping.entities.products;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PreemiumProductJoined extends ProductJoined{

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
