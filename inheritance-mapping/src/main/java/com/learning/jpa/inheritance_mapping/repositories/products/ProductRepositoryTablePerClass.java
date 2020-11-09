package com.learning.jpa.inheritance_mapping.repositories.products;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.products.FreemiumProductTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.products.PreemiumProductTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.products.ProductTablePerClass;

public interface ProductRepositoryTablePerClass extends CrudRepository<ProductTablePerClass, Integer>{
	
	@Query("select s from FreemiumProductTablePerClass s")
	public List<FreemiumProductTablePerClass> findFreemiumProducts();
	
	@Query("select s from PreemiumProductTablePerClass s")
	public List<PreemiumProductTablePerClass> findPreemiumProducts();
	
	//pagination support
	
	@Query("select s from FreemiumProductTablePerClass s")
	public List<FreemiumProductTablePerClass> findFreemiumProducts(Pageable pageable);
	
	@Query("select s from PreemiumProductTablePerClass s")
	public List<PreemiumProductTablePerClass> findPreemiumProducts(Pageable pageable);
	
}
