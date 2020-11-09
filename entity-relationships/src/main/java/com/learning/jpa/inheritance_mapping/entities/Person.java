package com.learning.jpa.inheritance_mapping.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	//delete/update/create idcard entity if same is happening on person
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private IdentificationCard identificationCard;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public IdentificationCard getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(IdentificationCard identificationCard) {
		this.identificationCard = identificationCard;
	}
	
	public void updateIdentificationCard(IdentificationCard identificationCard) {
		identificationCard.setValidFrom(LocalDate.now());
		LocalDate now = LocalDate.now();
		LocalDate plusYears = now.plusYears(10);
		identificationCard.setValidTo(plusYears);
		setIdentificationCard(identificationCard);
		identificationCard.setPerson(this);
	}
	
}
