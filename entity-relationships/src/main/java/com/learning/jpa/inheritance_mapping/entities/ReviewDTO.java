package com.learning.jpa.inheritance_mapping.entities;

public class ReviewDTO {

	public ReviewDTO() {
		
	}
	public ReviewDTO(Review review) {
		this.id = review.getId();
		this.comment = review.getComment();
		this.rating = review.getRating();
	}
	private Integer id;
	
	private String comment;
	
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

}
