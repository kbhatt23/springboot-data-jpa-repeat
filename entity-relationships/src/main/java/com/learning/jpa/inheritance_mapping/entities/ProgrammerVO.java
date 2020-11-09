package com.learning.jpa.inheritance_mapping.entities;

import java.util.List;
import java.util.stream.Collectors;

public class ProgrammerVO {

	private Integer id;
	
	private String name;
	
	private	Double salary;
	
	private List<ProjectProgrmmerVO> projects;

	public ProgrammerVO() {
	}
	public ProgrammerVO(Programmer programmer) {
		this.id= programmer.getId();
		this.name=programmer.getName();
		this.salary=programmer.getSalary();
		this.projects = programmer.getProjects().stream()
					.map(ProjectProgrmmerVO::new)
					.collect(Collectors.toList());
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

	public List<ProjectProgrmmerVO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectProgrmmerVO> projects) {
		this.projects = projects;
	}

	
}
