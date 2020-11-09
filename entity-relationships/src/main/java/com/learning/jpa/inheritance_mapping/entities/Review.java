package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String comment;
	
	//fetch will be eager
	//cascade should be emoty, meaning no modification will happen on course from this entity's repo methods
	@ManyToOne
	//in D.B it stores the course_id and not full object
	@JoinColumn(name = "course_id")
	private Course course;
	
	//since we know that sequence wont change we are using as ordinal -> the sequnce index will be saved as int in D.B,
	//if sequnce in enum class change then mapping will go wrong, our use case is happy to store as int
	//data type of rating in sql will be int, for any se
	private Rating rating;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
