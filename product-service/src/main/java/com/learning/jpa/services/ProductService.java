package com.learning.jpa.services;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.jpa.dtobeans.ProductDTO;
import com.learning.jpa.entities.Product;
import com.learning.jpa.repositories.ProductCRUDRepository;

@Service
//service class should do data/logicl manipulation and validations
//can not expect dao class /repo interface to do that
@Qualifier("simpleProductService")
@Transactional
@CacheConfig(cacheNames = "products")
public class ProductService implements IProductService{


	private static final String PRODUCT_NAME_CAN_NOT_BE_EMPTY = "Product Name can not be empty";
	private static final String PRODUCT_NOT_PRESENT_WITH_ID = "Product not present with ID ";
	//@Autowired
	private static ObjectMapper objectMapper = new ObjectMapper();
	public static final String PRODUCT_ID_PREPOPULATED_MSG = "Product can not have id pre populated";
	public static final Function<String, String> PRODUCT_ID_INTEGER_MSG_FUNCTION = id -> "Product ID has to be integer, value passed "+id;
	public static final Function<Product, ProductDTO> convertToDTOFunction = product -> objectMapper.convertValue(product, ProductDTO.class);
	
	private static final Function<ProductDTO, Product> convertToDAOFunction = productDTO -> objectMapper.convertValue(productDTO, Product.class);
	
	@Autowired
	private ProductCRUDRepository repository;
	
	private static Logger logger  = LoggerFactory.getLogger(ProductService.class);
	
	@Override
	public void createProduct(ProductDTO productDTO) {
		//service class should handle expcetions and do logical manipulations in data
		if(!StringUtils.isEmpty(productDTO.getId())) {
			logger.error("createProduct: "+PRODUCT_ID_PREPOPULATED_MSG);
			throw new RuntimeException(PRODUCT_ID_PREPOPULATED_MSG);
		}
		Product product = convertToDAOFunction.apply(productDTO);
		Product productSaved = repository.save(product);
		logger.info("createProduct: Saved Product with ID "+productSaved.getId());
	}
	//for all items the return type of this method is stored in cache with name product, and key as "all" as string
	@Cacheable()
	@Override
	public List<ProductDTO> findAllProducts(){
		 List<ProductDTO> products = repository.findAll()
				   .stream()
				   .map(product -> convertToDTOFunction.apply(product))
				   .collect(Collectors.toList());
		 printProductList("Any", products,"findAllProducts");
		 return products;
	}
	//argument id of method will be key and value will be productDTO class's object
	@Cacheable(key = "#id")
	@Override
	public ProductDTO findProductByID(String id) {
		handleInvalidID(id, "findProductByID");
		
		//added below code just to test level 1 cache
		//works within the same transaction if smae query has to be fired second time it wont call D.B
		
		
		return repository.findById(Integer.parseInt(id))
				.map(product -> convertToDTOFunction.apply(product))
				.orElseThrow(handleIDNotPresent("findProductByID", id))
				;
	}

	@CachePut(key = "#productDTO.id.toString()")
	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
			Integer id = productDTO.getId();
			repository.findById(id)
					  .map(existing -> convertToDAOFunction.apply(productDTO))
					  .map(dto -> repository.save(dto))
					  .orElseThrow(handleIDNotPresent("findProductByID", id.toString()))
					  ;
			return productDTO;
		
	}

	@CacheEvict(key = "#id")
	@Override
	public void removeProduct(String id) {
		handleInvalidID(id, "removeProduct");
		repository.findById(Integer.parseInt(id))
				  .map(existing -> {
					  repository.delete(existing);
					  return "done";
				  })
				  .orElseThrow(handleIDNotPresent("findProductByID", id))
				  
				 ;
	}
	
	public void handleInvalidID(String id, String methodName) {
		if(!GeneralUtility.isInteger(id)) {
			String idInvalidMsg = PRODUCT_ID_INTEGER_MSG_FUNCTION.apply(id);
			logger.error(methodName+": "+idInvalidMsg);
			throw new RuntimeException(idInvalidMsg);
		}
	}
	
	public Supplier<RuntimeException> handleIDNotPresent(String methodName , String id){
		return () -> {
			logger.error(methodName+": "+PRODUCT_NOT_PRESENT_WITH_ID+id);
			return new RuntimeException(PRODUCT_NOT_PRESENT_WITH_ID+id);
		  };
	}

	@Override
	public List<ProductDTO> findByName(String name) {
		handleNameString(name);
		 List<ProductDTO> products = repository.findByName(name)
				   .stream()
				   .map(product -> convertToDTOFunction.apply(product))
				   .collect(Collectors.toList());
		 printProductList(name, products,"findByName");
		 return products;
	}

	private void handleNameString(String name) {
		if(StringUtils.isEmpty(name)) {
			logger.error(PRODUCT_NAME_CAN_NOT_BE_EMPTY);
			throw new RuntimeException(PRODUCT_NAME_CAN_NOT_BE_EMPTY);
		}
	}

	@Override
	public List<ProductDTO> findByNameContains(String name) {
		handleNameString(name);
		 List<ProductDTO> products = repository.findByNameContains(name)
				   .stream()
				   .map(product -> convertToDTOFunction.apply(product))
				   .collect(Collectors.toList());
		 printProductList(name, products,"findByNameContains");
		 return products;
	}

	public static void printProductList(String name, List<ProductDTO> products,String methodName) {
		if(products == null || products.isEmpty()) {
			 logger.info(methodName+": No Products found with name "+name);
		 }else {
			 logger.info(methodName+": Found Products with size "+products.size());
		 }
	}

	@Override
	public List<ProductDTO> findByNGreaterThanPrice(String price) {
		List<ProductDTO> products = repository.findByPriceGreaterThan(Double.parseDouble(price))
				   .stream()
				   .map(product -> convertToDTOFunction.apply(product))
				   .collect(Collectors.toList());
		 printProductList("price greater than "+price, products,"findByNGreaterThanPrice");
		 return products;
	}

	@Override
	public List<ProductDTO> findByNameAndDesc(String name, String desc) {
		handleNameString(name);
		handleNameString(desc);
		
		 List<ProductDTO> products = repository.findByNameAndDesc(name, desc)				   .stream()
				   .map(product -> convertToDTOFunction.apply(product))
				   .collect(Collectors.toList());
		 printProductList(name+" and description "+desc, products,"findByNameAndDesc");
		 return products;
	}
}
