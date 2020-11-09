package com.learning.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.entities.EmployeeIdentityStrategy;

public interface EmployeeIdentityStrategyRepository extends CrudRepository<EmployeeIdentityStrategy, Long>{

	List<EmployeeIdentityStrategy> findAll();
}
