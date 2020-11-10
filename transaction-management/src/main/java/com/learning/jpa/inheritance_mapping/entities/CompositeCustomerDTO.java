package com.learning.jpa.inheritance_mapping.entities;

public class CompositeCustomerDTO {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int age;
	
	private String phoneNumber;
	
	public CompositeCustomerDTO(){
		
	}
	
	public CompositeCustomerDTO(CompositeCustomerV2 compositeCustomerV2) {
		this.firstName = compositeCustomerV2.getCompositeKey().getFirstName();
		this.lastName=compositeCustomerV2.getCompositeKey().getLastName();
		this.email=compositeCustomerV2.getCompositeKey().getEmail();
		this.age=compositeCustomerV2.getAge();
		this.phoneNumber=compositeCustomerV2.getPhoneNumber();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
