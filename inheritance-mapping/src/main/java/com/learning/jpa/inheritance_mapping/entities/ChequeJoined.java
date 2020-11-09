package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//we will have sperate table for this having foreign key reference for super class table
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ChequeJoined extends PaymentJoined{
	
	//automatic column name - > cheque_number
	private String chequeNumber;

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
}
