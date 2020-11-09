package com.learning.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.entities.StudentWithAddress;
import com.learning.jpa.repository.StudentCRUDRepository;

@RestController
@RequestMapping("/student-with-address")
public class StudentWithAddressController {

	@Autowired
	private StudentCRUDRepository repo;
	
	@PostMapping
	public void createStudent(@RequestBody StudentWithAddress student) {
		repo.save(student);	
	}
	
	@GetMapping
	public List<StudentWithAddress> findAll(){
		return repo.findAll();
	}
}
