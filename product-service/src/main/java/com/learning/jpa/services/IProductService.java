package com.learning.jpa.services;

import java.util.List;

import com.learning.jpa.dtobeans.ProductDTO;

public interface IProductService {
	void createProduct(ProductDTO productDTO);
	 
	List<ProductDTO> findAllProducts();

	ProductDTO findProductByID(String id);

	ProductDTO updateProduct(ProductDTO productDTO);

	void removeProduct(String id);
	
	List<ProductDTO> findByName(String name);
	List<ProductDTO> findByNameAndDesc(String name,String desc);
	
	List<ProductDTO> findByNameContains(String name);
	
	List<ProductDTO> findByNGreaterThanPrice(String price);
}
