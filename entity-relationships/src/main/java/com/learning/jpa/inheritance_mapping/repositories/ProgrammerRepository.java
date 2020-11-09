package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer>{

	List<Programmer> findAll();
}
