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
import com.learning.jpa.inheritance_mapping.entities.Project;
import com.learning.jpa.inheritance_mapping.entities.ProjectVO;
import com.learning.jpa.inheritance_mapping.repositories.ProgrammerRepository;
import com.learning.jpa.inheritance_mapping.repositories.ProjectRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	private ProgrammerRepository repository2;
	
	@PostMapping
	public void createProjectr(@RequestBody Project project) {
		repository.save(project);
	}
	
	@GetMapping
	public List<ProjectVO> findAllProjects(){
		return repository.findAll()
			.stream()
			.map(ProjectVO::new)
			.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ProjectVO findById(@PathVariable String id) {
		return repository.findById(Integer.parseInt(id))
				.map(ProjectVO::new)
				.orElseThrow(() -> new RuntimeException("Project is not present wit id "+id));
	}
	
	@PostMapping("/{id}/programmer/{pID}")
	public void addProgrammertoProject(@PathVariable String id , @PathVariable String pID) {
		repository.findById(Integer.parseInt(id))
				  .map(a -> {
					  Programmer existingProgrammer = repository2.findById(Integer.parseInt(pID)).orElse(null);
					  a.addProgrammer(existingProgrammer, true)
					;
				  //cascading will auto update
					  if(existingProgrammer != null) 
						  repository.save(a);
				  return true;
				  }).orElseThrow(() -> new RuntimeException("No Project exist with ID "+id))
				  
		;
	}
	
	@DeleteMapping("/{id}/programmer/{pID}")
	public void removeProgrammerFromProject(@PathVariable String id , @PathVariable String pID) {
		repository.findById(Integer.parseInt(id))
				  .map(a -> {
					  Programmer existingProgrammer = repository2.findById(Integer.parseInt(pID)).orElse(null);
					  a.removeProgrammer(existingProgrammer, true);
					  if(existingProgrammer != null)
						  repository.save(a);
				  return true;
				  }).orElseThrow(() -> new RuntimeException("No Project exist with ID "+id))
				  
		;
	}
	
	@DeleteMapping("/{id}")
	public void removeProject(@PathVariable String id) {
		int idInt = Integer.parseInt(id);
		repository.findById(idInt)
		  		  .map(p ->{
		  			  List<Programmer> programmers = p.getProgrammers();
		  			programmers.forEach(a ->{
		  			a.removeProject(p, false);
		  			repository2.save(a);
		  			});
		  			  return true;
		  			  })
				  .orElseThrow(() -> new RuntimeException("No Project exist with ID "+id))
		  		  ;	
		repository.deleteById(idInt);
	}
}
