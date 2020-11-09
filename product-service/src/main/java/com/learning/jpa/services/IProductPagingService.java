package com.learning.jpa.services;

import java.util.List;

import com.learning.jpa.dtobeans.ProductDTO;

public interface IProductPagingService {

	List<ProductDTO> paginateProducts(String page);
	
	List<ProductDTO> findAllSortedByPrice();
	
	List<ProductDTO> paginateAndSortProducts(String page);

	List<ProductDTO> paginateAndSortByMultipleOrderProducts(String pageNumber);
	
	List<ProductDTO> paginateProductsByName(String pageNumber,String name);
}
