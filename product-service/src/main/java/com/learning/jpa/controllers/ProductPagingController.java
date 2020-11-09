package com.learning.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.dtobeans.ProductDTO;
import com.learning.jpa.services.IProductPagingService;

@RestController
@RequestMapping("/products/paginate")
public class ProductPagingController {

	@Autowired
	private IProductPagingService service; 
	
	@GetMapping("/{page}")
	public List<ProductDTO> paginateAllProducts(@PathVariable String page){
		return service.paginateProducts(page);
	}
	
	@GetMapping("/sorted")
	public List<ProductDTO> sortAllProducts(){
		return service.findAllSortedByPrice();
	}
	
	@GetMapping("/sortedPagination/{page}")
	public List<ProductDTO> paginateAndSortAllProducts(@PathVariable String page){
		return service.paginateAndSortProducts(page);
	}
	@GetMapping("/sortedMultipleOrderPagination/{page}")
	public List<ProductDTO> paginateAndSortByMultiupleOrdersAllProducts(@PathVariable String page){
		return service.paginateAndSortByMultipleOrderProducts(page);
	}
	
	@GetMapping("/sortedPagination/{page}/name/{name}")
	public List<ProductDTO> paginateAndSortAllProducts(@PathVariable String page, @PathVariable String name){
		return service.paginateProductsByName(page, name);
	}
}
