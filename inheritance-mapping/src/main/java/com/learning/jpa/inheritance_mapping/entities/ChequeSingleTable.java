package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//no need to create sperate table for this
@Entity
@DiscriminatorValue("cheque")
public class ChequeSingleTable extends PaymentSingleTable{
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
