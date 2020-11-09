package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.Person;
//same repo to handle person and id
public interface PersonRepository extends CrudRepository<Person, Integer>{

	List<Person> findAll();
}
