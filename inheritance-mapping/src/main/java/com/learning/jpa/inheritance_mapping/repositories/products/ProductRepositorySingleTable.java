package com.learning.jpa.inheritance_mapping.repositories.products;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.learning.jpa.inheritance_mapping.entities.products.ProductSingleTable;

public interface ProductRepositorySingleTable extends CrudRepository<ProductSingleTable, Integer>{
	
	@Query(nativeQuery = true, value = "select * from product_single_table where product_type=:productType")
	public List<ProductSingleTable> findProductByType(@Param("productType") String productType);
	
}
