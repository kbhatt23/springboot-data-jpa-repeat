package com.learning.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.entities.EmployeeTableStrategy;

public interface EmployeeTableStrategyRepository extends CrudRepository<EmployeeTableStrategy, Long>{

	List<EmployeeTableStrategy> findAll();
}
