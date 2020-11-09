package com.learning.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.learning.jpa.entities.Product;
@Repository
public interface ProductPagingRepository extends PagingAndSortingRepository<Product, Integer>{

	List<Product> findAll();
	
	Optional<Product> findById(Integer id);
	
	//finder methods
	List<Product> findByName(String name);
	
	Page<Product> findByName(String name,Pageable pageable);
	List<Product> findByNameAndDesc(String name,String desc);
	
	List<Product> findByNameContains(String name);
	
	//find products with price greater than passed argument
	List<Product> findByPriceGreaterThan(Double price);
	
	List<Product> findAll(Sort sort);
}
