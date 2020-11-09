package com.learning.jpa.inheritance_mapping.entities;

//course vo view only, no need to shpw review here as it is part of review vo
public class CourseVO {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	public CourseVO() {
	}
	
	public CourseVO(Course course) {
		this.id = course.getId();
		this.description = course.getDescription();
		this.name= course.getName();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
