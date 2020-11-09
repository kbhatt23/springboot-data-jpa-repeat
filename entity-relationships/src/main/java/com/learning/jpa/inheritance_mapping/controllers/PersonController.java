package com.learning.jpa.inheritance_mapping.controllers;

import java.time.LocalDate;
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

import com.learning.jpa.inheritance_mapping.entities.IdentificationCard;
import com.learning.jpa.inheritance_mapping.entities.Person;
import com.learning.jpa.inheritance_mapping.entities.PersonVO;
import com.learning.jpa.inheritance_mapping.repositories.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonRepository repository;
	
	@PostMapping
	public void createPerson(@RequestBody Person person) {
		repository.save(person);
	}
	
	@GetMapping
	public List<PersonVO> findAllPerson(){
		return repository.findAll().stream()
					.map(PersonVO::new)
					.collect(Collectors.toList());
		
	}
	
	@GetMapping("/{id}")
	public PersonVO findPerson(@PathVariable String id){
		return repository.findById(Integer.parseInt(id))
				.map(PersonVO::new)
				.orElseThrow(() -> new RuntimeException("Person not persent with id "+id));
	}
	
	@PostMapping("/{id}")
	public void updatePersonIdentification(@PathVariable String id, @RequestBody IdentificationCard card){
		repository.findById(Integer.parseInt(id))
				.map(p -> {
					p.updateIdentificationCard(card);
					;
				repository.save(p);
				return true;
				}).orElseThrow(() -> new RuntimeException("Person not persent with id "+id))
				;
	}
	
	@DeleteMapping("/{id}")
	public void deletePErson(@PathVariable String id) {
		repository.deleteById(Integer.parseInt(id));
	}
}
