package com.learning.jpa.inheritance_mapping.entities;

public class ReviewVO {

	public ReviewVO() {
		
	}
	public ReviewVO(Review review) {
		this.id = review.getId();
		this.comment = review.getComment();
		this.rating = review.getRating();
		this.course = new CourseVO(review.getCourse());
	}
	private Integer id;
	
	private String comment;
	
	private Rating rating;
	
	private CourseVO course;

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
	public CourseVO getCourse() {
		return course;
	}
	public void setCourse(CourseVO course) {
		this.course = course;
	}

}
