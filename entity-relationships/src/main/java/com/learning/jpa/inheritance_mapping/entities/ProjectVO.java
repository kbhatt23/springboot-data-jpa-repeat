package com.learning.jpa.inheritance_mapping.entities;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectVO {
	private Integer id;

	private String clientName;

	private String description;

	private List<ProgrammerProjectVO> programmers;
	
	public ProjectVO() {
	}
	
	public ProjectVO(Project project) {
		this.id = project.getId();
		this.clientName = project.getClientName();
		this.description = project.getDescription();
		this.programmers = project.getProgrammers()
				.stream()
				.map(ProgrammerProjectVO::new)
				.collect(Collectors.toList());
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

	public List<ProgrammerProjectVO> getProgrammers() {
		return programmers;
	}

	public void setProgrammers(List<ProgrammerProjectVO> programmers) {
		this.programmers = programmers;
	}

}
