package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//no need to create sperate table for this
@Entity
//value to put in discriminator column
@DiscriminatorValue("credit-card")
public class CreditCardSingleTable extends PaymentSingleTable{
	//no need of priamry column -> inherited from super class
	
	//automatic column name - > card_number
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
