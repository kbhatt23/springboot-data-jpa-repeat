package com.learning.jpa.inheritance_mapping.controllers.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.products.FreemiumProductJoined;
import com.learning.jpa.inheritance_mapping.entities.products.PreemiumProductJoined;
import com.learning.jpa.inheritance_mapping.repositories.products.ProductRepositoryJoined;

@RestController
@RequestMapping("/products/joined")
public class ProductControllerJoined {
	
	@Autowired
	private ProductRepositoryJoined repository;
	
	@PostMapping("/freemium")
	public void createFreemiumProduct(@RequestBody FreemiumProductJoined product) {
		repository.save(product);
	}
	@GetMapping("/freemium")
	public List<FreemiumProductJoined> findAllFreemiumProduct() {
		return repository.findFreemiumProducts();
	}
	
	@PostMapping("/preemium")
	public void createPreemiumProduct(@RequestBody PreemiumProductJoined product) {
		repository.save(product);
	}
	@GetMapping("/preemium")
	public List<PreemiumProductJoined> findAllPreemiumProduct() {
		return repository.findPreemiumProducts();
	}
	
	
	//pagination support
	@GetMapping("/freemium/paginate/{pageNumber}")
	public List<FreemiumProductJoined> findAllFreemiumProductPaginate(@PathVariable String pageNumber) {
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), 2, Sort.by(Sort.Order.asc("name")));
		return repository.findFreemiumProducts(pageable);
	}
	
	@GetMapping("/preemium/paginate/{pageNumber}")
	public List<PreemiumProductJoined> findAllPreemiumProductPaginate(@PathVariable String pageNumber) {
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), 2, Sort.by(Sort.Order.asc("name")));
		return repository.findPreemiumProducts(pageable);
	}
}
