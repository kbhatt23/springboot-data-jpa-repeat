package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//we will have sperate table for this having foreign key reference for super class table
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CreditCardJoined extends PaymentJoined{
	
	//automatic column name - > card_number
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
