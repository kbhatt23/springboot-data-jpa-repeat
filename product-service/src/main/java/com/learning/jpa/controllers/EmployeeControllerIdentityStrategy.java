package com.learning.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.entities.EmployeeIdentityStrategy;
import com.learning.jpa.repositories.EmployeeIdentityStrategyRepository;

@RestController
@RequestMapping("/identity-strategy/employees")
public class EmployeeControllerIdentityStrategy {
	@Autowired
	private EmployeeIdentityStrategyRepository repo;
	
	@GetMapping
	public List<EmployeeIdentityStrategy> findAll(){
		return repo.findAll();
	}
	
	@PostMapping
	public void create(@RequestBody EmployeeIdentityStrategy employee) {
		repo.save(employee);
	}
}
