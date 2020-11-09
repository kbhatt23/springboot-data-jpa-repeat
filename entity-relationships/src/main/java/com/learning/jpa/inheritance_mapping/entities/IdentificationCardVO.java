package com.learning.jpa.inheritance_mapping.entities;

import java.time.LocalDate;

public class IdentificationCardVO {
	private Integer id;
	
	private LocalDate validFrom;
	
	private LocalDate validTo;
	
	private String cardNumber;
	
	private CardType cardType;
	
	public IdentificationCardVO() {
		
	}
	public IdentificationCardVO(IdentificationCard card) {
		this.id=card.getId();
		this.validFrom = card.getValidFrom();
		this.validTo=card.getValidTo();
		this.cardNumber = card.getCardNumber();
		this.cardType = card.getCardType();
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}

	public LocalDate getValidTo() {
		return validTo;
	}

	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
	

}
