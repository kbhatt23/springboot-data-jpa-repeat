package com.learning.jpa.inheritance_mapping.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class ProjectProgrmmerVO {
	private Integer id;
	
	private String clientName;
	
	private String description;
	
	public ProjectProgrmmerVO() {
		
	}
	public ProjectProgrmmerVO(Project project){
		this.id = project.getId();
		this.clientName = project.getClientName();
		this.description = project.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
