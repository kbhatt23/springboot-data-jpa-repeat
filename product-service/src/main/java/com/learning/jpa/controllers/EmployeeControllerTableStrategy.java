package com.learning.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.entities.EmployeeTableStrategy;
import com.learning.jpa.repositories.EmployeeTableStrategyRepository;

@RestController
@RequestMapping("/table-strategy/employees")
public class EmployeeControllerTableStrategy {
	@Autowired
	private EmployeeTableStrategyRepository repo;
	
	@GetMapping
	public List<EmployeeTableStrategy> findAll(){
		return repo.findAll();
	}
	
	@PostMapping
	public void create(@RequestBody EmployeeTableStrategy employee) {
		repo.save(employee);
	}
}
