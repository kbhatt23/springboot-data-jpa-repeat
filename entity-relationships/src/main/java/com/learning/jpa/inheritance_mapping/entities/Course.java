package com.learning.jpa.inheritance_mapping.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String description;
	
	//if course is removed the review should get removed/updated/inserted -> otherwise we will have to create 2 sepearet repository and call the methods
	//default fetchtype is lazy
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private List<Review> reviews;
	
	public void addReview(Review review) {
		if(review ==null) {
			return;
		}
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		review.setCourse(this);
		reviews.add(review);
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

	public List<Review> getReviews() {
		return reviews;
	}
	
}
