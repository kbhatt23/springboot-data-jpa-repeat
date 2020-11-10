package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//no need in embededble approach
//@IdClass(value = CompositeKeyV1.class)
public class CompositeCustomerV2 {

	//composite keys
	//@Id
	//private String firstName;
	
	//@Id
	//private String lastName;
	
	//@Id
	//private String email;
	
	//acting as priamry key, only difernece is in DTO and find by queries using jpql
	@EmbeddedId
	private CompositeKeyV2 compositeKey;
	
	private int age;
	
	private String phoneNumber;
	
	public CompositeCustomerV2() {
		
	}
	public CompositeCustomerV2(CompositeCustomerDTO compositeCustomerDTO) {
		this.age = compositeCustomerDTO.getAge();
		this.phoneNumber = compositeCustomerDTO.getPhoneNumber();
		this.compositeKey = new CompositeKeyV2(compositeCustomerDTO);
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public CompositeKeyV2 getCompositeKey() {
		return compositeKey;
	}
	public void setCompositeKey(CompositeKeyV2 compositeKey) {
		this.compositeKey = compositeKey;
	}

}
