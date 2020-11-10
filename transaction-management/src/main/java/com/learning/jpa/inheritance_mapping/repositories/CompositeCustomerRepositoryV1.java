package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.CompositeCustomerV1;
import com.learning.jpa.inheritance_mapping.entities.CompositeKeyV1;

public interface CompositeCustomerRepositoryV1 extends CrudRepository<CompositeCustomerV1, CompositeKeyV1>{
	List<CompositeCustomerV1> findAll();
	
	//this wont be possible in embedded id way of compiste keys
	//as firstname wont be present in main class -> we will need jpql for that case
	List<CompositeCustomerV1> findByFirstName(String firstName);

}
