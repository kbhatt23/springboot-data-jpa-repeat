package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

	List<Project> findAll();
}
