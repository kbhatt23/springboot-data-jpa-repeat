package com.learning.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.entities.StudentWithAddress;

public interface StudentCRUDRepository extends CrudRepository<StudentWithAddress, Long>{

	List<StudentWithAddress> findAll();
}
