package com.learning.jpa.inheritance_mapping.controllers.products;

import java.util.List;
import java.util.stream.Collectors;

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

import com.learning.jpa.inheritance_mapping.entities.products.FreemiumProductSingleTable;
import com.learning.jpa.inheritance_mapping.entities.products.FreemiumProductTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.products.PreemiumProductSingleTable;
import com.learning.jpa.inheritance_mapping.entities.products.PreemiumProductTablePerClass;
import com.learning.jpa.inheritance_mapping.repositories.products.ProductRepositorySingleTable;
import com.learning.jpa.inheritance_mapping.repositories.products.ProductRepositoryTablePerClass;

@RestController
@RequestMapping("/products/table-per-class")
public class ProductControllerTablePerClass {
	
	@Autowired
	private ProductRepositoryTablePerClass repository;
	
	@PostMapping("/freemium")
	public void createFreemiumProduct(@RequestBody FreemiumProductTablePerClass product) {
		repository.save(product);
	}
	@GetMapping("/freemium")
	public List<FreemiumProductTablePerClass> findAllFreemiumProduct() {
		return repository.findFreemiumProducts();
	}
	
	@PostMapping("/preemium")
	public void createPreemiumProduct(@RequestBody PreemiumProductTablePerClass product) {
		repository.save(product);
	}
	@GetMapping("/preemium")
	public List<PreemiumProductTablePerClass> findAllPreemiumProduct() {
		return repository.findPreemiumProducts();
	}
	
	
	//pagination support
	@GetMapping("/freemium/paginate/{pageNumber}")
	public List<FreemiumProductTablePerClass> findAllFreemiumProductPaginate(@PathVariable String pageNumber) {
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), 2, Sort.by(Sort.Order.asc("name")));
		return repository.findFreemiumProducts(pageable);
	}
	
	@GetMapping("/preemium/paginate/{pageNumber}")
	public List<PreemiumProductTablePerClass> findAllPreemiumProductPaginate(@PathVariable String pageNumber) {
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), 2, Sort.by(Sort.Order.asc("name")));
		return repository.findPreemiumProducts(pageable);
	}
}
