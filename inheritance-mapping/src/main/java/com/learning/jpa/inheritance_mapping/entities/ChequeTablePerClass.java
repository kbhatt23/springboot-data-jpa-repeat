package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.Entity;

//seperate table for this, super class table do not even exit
//all the common columns are present in all the sub type tables
@Entity
public class ChequeTablePerClass extends PaymentTablePerClass{
	//no need of priamry column -> inherited from super class
	
	//automatic column name - > cheque_number
	private String chequeNumber;

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
}
