package com.learning.jpa.inheritance_mapping.repositories.products;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.products.FreemiumProductJoined;
import com.learning.jpa.inheritance_mapping.entities.products.PreemiumProductJoined;
import com.learning.jpa.inheritance_mapping.entities.products.ProductJoined;

public interface ProductRepositoryJoined extends CrudRepository<ProductJoined, Integer>{
	
	@Query("select s from FreemiumProductJoined s")
	public List<FreemiumProductJoined> findFreemiumProducts();
	
	@Query("select s from PreemiumProductJoined s")
	public List<PreemiumProductJoined> findPreemiumProducts();
	
	//pagination support
	
	@Query("select s from FreemiumProductJoined s")
	public List<FreemiumProductJoined> findFreemiumProducts(Pageable pageable);
	
	@Query("select s from PreemiumProductJoined s")
	public List<PreemiumProductJoined> findPreemiumProducts(Pageable pageable);
	
}
