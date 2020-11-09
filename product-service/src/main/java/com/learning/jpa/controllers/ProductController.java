package com.learning.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.dtobeans.ProductDTO;
import com.learning.jpa.services.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	@Qualifier("simpleProductService")
	private IProductService service; 
	
	
	@GetMapping
	public List<ProductDTO> findAllProducts(){
		return service.findAllProducts();	
	}
	
	@PostMapping
	public void createProduct(@RequestBody ProductDTO productDTO) {
		service.createProduct(productDTO);
	}
	
	@GetMapping("/{id}")
	public ProductDTO findProductWithID(@PathVariable String id) {
		return service.findProductByID(id);
	}
	
	@PutMapping
	public void updateProduct(@RequestBody ProductDTO productDTO) {
		service.updateProduct(productDTO);
	}
	
	@DeleteMapping("/{id}")
	public void delteProduct(@PathVariable String id) {
		service.removeProduct(id);
	}
	
	@GetMapping("/name/{name}")
	public List<ProductDTO> findProductsByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping("/name/{name}/desc/{desc}")
	public List<ProductDTO> findProductsByNameAndDesc(@PathVariable String name,@PathVariable String desc){
		return service.findByNameAndDesc(name, desc);
	}
	
	@GetMapping("/nameContains/{name}")
	public List<ProductDTO> findProductsByNameContains(@PathVariable String name){
		return service.findByNameContains(name);
	}
	
	@GetMapping("/greaterThanPrice/{price}")
	public List<ProductDTO> findByGreaterThanPrice(@PathVariable String price){
		return service.findByNGreaterThanPrice(price);
	}
}
