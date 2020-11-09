package com.learning.jpa.inheritance_mapping.entities;

public class ProgrammerProjectVO {

	private Integer id;

	private String name;

	private Double salary;
	
	public ProgrammerProjectVO() {
		
	}
	public ProgrammerProjectVO(Programmer programmer) {
		this.id= programmer.getId();
		this.name=programmer.getName();
		this.salary=programmer.getSalary();
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
