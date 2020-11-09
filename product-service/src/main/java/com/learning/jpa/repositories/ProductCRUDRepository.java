package com.learning.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.jpa.entities.Product;
import java.lang.Double;
@Repository
public interface ProductCRUDRepository extends CrudRepository<Product, Integer>{

	List<Product> findAll();
	
	Optional<Product> findById(Integer id);
	
	//finder methods
	List<Product> findByName(String name);
	List<Product> findByNameAndDesc(String name,String desc);
	
	List<Product> findByNameContains(String name);
	
	//find products with price greater than passed argument
	List<Product> findByPriceGreaterThan(Double price);
}
