package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.learning.jpa.inheritance_mapping.entities.CompositeCustomerV2;
import com.learning.jpa.inheritance_mapping.entities.CompositeKeyV2;

public interface CompositeCustomerRepositoryV2 extends CrudRepository<CompositeCustomerV2, CompositeKeyV2>{
	List<CompositeCustomerV2> findAll();
	
	//this wont be possible in embedded id way of compiste keys
	//as firstname wont be present in main class -> we will need jpql for that case
	//List<CompositeCustomerV1> findByFirstName(String firstName);

	@Query(value = "select c from CompositeCustomerV2 c where c.compositeKey.firstName=:firstName")
	List<CompositeCustomerV2> findByFirstName(@Param(value = "firstName")String firstName);
}
