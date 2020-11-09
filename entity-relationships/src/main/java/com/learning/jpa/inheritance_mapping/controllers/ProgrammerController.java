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

import com.learning.jpa.inheritance_mapping.entities.Programmer;
import com.learning.jpa.inheritance_mapping.entities.ProgrammerVO;
import com.learning.jpa.inheritance_mapping.repositories.ProgrammerRepository;

@RestController
@RequestMapping("/programmers")
public class ProgrammerController {

	@Autowired
	private ProgrammerRepository repository;
	
	@PostMapping
	public void createProgrammer(@RequestBody Programmer programmer) {
		repository.save(programmer);
	}
	
	@GetMapping
	public List<ProgrammerVO> findAllProgrammers(){
		return repository.findAll()
			.stream()
			.map(ProgrammerVO::new)
			.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ProgrammerVO findById(@PathVariable String id) {
		return repository.findById(Integer.parseInt(id))
				.map(ProgrammerVO::new)
				.orElseThrow(() -> new RuntimeException("Programmer is not present wit id "+id));
	}
	
	@DeleteMapping("/{id}")
	public void removeProgrammer(@PathVariable String id) {
		repository.deleteById(Integer.parseInt(id));
	}
}
