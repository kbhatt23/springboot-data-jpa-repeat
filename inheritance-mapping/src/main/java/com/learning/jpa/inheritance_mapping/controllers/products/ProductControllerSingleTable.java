package com.learning.jpa.inheritance_mapping.controllers.products;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.products.FreemiumProductSingleTable;
import com.learning.jpa.inheritance_mapping.entities.products.PreemiumProductSingleTable;
import com.learning.jpa.inheritance_mapping.repositories.products.ProductRepositorySingleTable;

@RestController
@RequestMapping("/products/single-table")
public class ProductControllerSingleTable {
	
	@Autowired
	private ProductRepositorySingleTable repository;
	
	@PostMapping("/freemium")
	public void createFreemiumProduct(@RequestBody FreemiumProductSingleTable product) {
		repository.save(product);
	}
	@GetMapping("/freemium")
	public List<FreemiumProductSingleTable> findAllFreemiumProduct() {
		return repository.findProductByType("freemium")
				.stream()
				.map(a -> (FreemiumProductSingleTable)a)
				.collect(Collectors.toList())
				;
	}
	
	@PostMapping("/preemium")
	public void createPreemiumProduct(@RequestBody PreemiumProductSingleTable product) {
		repository.save(product);
	}
	@GetMapping("/preemium")
	public List<PreemiumProductSingleTable> findAllPreemiumProduct() {
		return repository.findProductByType("preemium")
				.stream()
				.map(a -> (PreemiumProductSingleTable)a)
				.collect(Collectors.toList())
				;
	}
}
