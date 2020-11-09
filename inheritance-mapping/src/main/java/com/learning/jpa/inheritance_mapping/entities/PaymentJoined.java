package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
//automatic table name will be payment_single_table
import javax.persistence.InheritanceType;
@Entity
//need to define inheritance strategy
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentJoined {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
