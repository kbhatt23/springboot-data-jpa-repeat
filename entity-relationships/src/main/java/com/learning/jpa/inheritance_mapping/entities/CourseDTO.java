package com.learning.jpa.inheritance_mapping.entities;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDTO {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private List<ReviewDTO> reviews;
	
	public CourseDTO() {
		
	}
	
	public CourseDTO(Course course) {
		this.id = course.getId();
		this.description = course.getDescription();
		this.name= course.getName();
		this.reviews = course.getReviews().stream()
									.map(ReviewDTO::new)
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
	
}
