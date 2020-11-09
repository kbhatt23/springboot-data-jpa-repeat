package com.learning.jpa.inheritance_mapping.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.Course;
import com.learning.jpa.inheritance_mapping.entities.CourseDTO;
import com.learning.jpa.inheritance_mapping.entities.Review;
import com.learning.jpa.inheritance_mapping.entities.ReviewVO;
import com.learning.jpa.inheritance_mapping.repositories.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseRepository repository;
	
	@PostMapping
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	@PostMapping("/{courseID}/reviews")
	public void addReview(@RequestBody Review review, @PathVariable String courseID) {
		repository.findById(Integer.parseInt(courseID))
					.map(c -> {
						c.addReview(review);
						repository.save(c);
						return c;
					})
					.orElseThrow(() -> new RuntimeException("Course with ID "+courseID+" do not exist"))
				  ;
	}
	
	@GetMapping
	public List<CourseDTO> findAllCourse(){
		return repository.findAll()
				.stream()
				.map(CourseDTO::new)
				.collect(Collectors.toList())
				;
	}
	
	@DeleteMapping("/{courseID}")
	public void delteCourse(@PathVariable String courseID) {
		repository.deleteById(Integer.parseInt(courseID));
	}
	
	@GetMapping("/reviews/{reviewID}")
	public ReviewVO fetchReview(@PathVariable String reviewID) {
		return repository.findAll()
				 .stream()
				 .map(c -> c.getReviews())
				 .flatMap(List::stream)
				 .filter(r -> Integer.parseInt(reviewID) == r.getId())
				 .findFirst()
				 .map(ReviewVO::new)
				 .orElseThrow(() -> new RuntimeException("Review with ID "+reviewID+" do not exist"));
		
	}
}
