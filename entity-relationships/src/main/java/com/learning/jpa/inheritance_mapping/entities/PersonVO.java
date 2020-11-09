package com.learning.jpa.inheritance_mapping.entities;

public class PersonVO {
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private IdentificationCardVO identificationCard;
	
	public PersonVO() {
		
	}
	public PersonVO(Person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.age=person.getAge()
				;
		if(person.getIdentificationCard() != null) {
		this.identificationCard = new IdentificationCardVO(person.getIdentificationCard());
		}
	}

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

	public IdentificationCardVO getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(IdentificationCardVO identificationCard) {
		this.identificationCard = identificationCard;
	}
	
	
}
