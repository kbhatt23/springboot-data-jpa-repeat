package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	List<Course> findAll();
}
