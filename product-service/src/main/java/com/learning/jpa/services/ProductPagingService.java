package com.learning.jpa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.learning.jpa.dtobeans.ProductDTO;
import com.learning.jpa.entities.Product;
import com.learning.jpa.repositories.ProductPagingRepository;

@Service
public class ProductPagingService implements IProductPagingService{
	@Value("${sizePerPage:1}")
	private static final int sizePerPage=2;
	
	private static final String EMPTY_PAGE_MSG = "Page can not be Empty";
	private static final String INVALID_PAGE_NUMBER_MSG = "Page number has to be integer";
	private static Logger logger  = LoggerFactory.getLogger(ProductPagingService.class);
	
	private static Sort SORT_BY_PRICE_DESC = Sort.by(Sort.Order.desc("price"));
	
	private static Sort SORT_BY_PRICE_ASC = Sort.by(Sort.Order.asc("price"));
	
	private static Sort SORT_BY_PRICE_AND_NAME_ASC =Sort.by(Sort.Order.asc("price"),Sort.Order.asc("name"));
	
	@Autowired
	private ProductPagingRepository repository;
	
	@Override
	public List<ProductDTO> paginateProducts(String pageNumber) {
		logger.info("Starting page gneration for page number "+pageNumber+ " with sizePerPage "+sizePerPage);
		handleEmptyPageNumber(pageNumber);
		handleInvalidPageNumber(pageNumber);
		Pageable pageable =PageRequest.of(Integer.parseInt(pageNumber), sizePerPage);
		Page<Product> pageProduct = repository.findAll(pageable);
		return pageProduct.map(ProductService.convertToDTOFunction).getContent();
	}

	private void handleInvalidPageNumber(String pageNumber) {
		if(!GeneralUtility.isInteger(pageNumber)) {
			String msg = "paginateProducts: "+INVALID_PAGE_NUMBER_MSG+ ", value passed "+pageNumber;
			logger.error(msg);
			throw new RuntimeException(msg);
		}
	}

	private void handleEmptyPageNumber(String pageNumber) {
		if(StringUtils.isEmpty(pageNumber)) {
			String msg = "paginateProducts: "+EMPTY_PAGE_MSG;
			logger.error(msg);
			throw new RuntimeException(msg);
		}
	}

	@Override
	public List<ProductDTO> findAllSortedByPrice() {
		 List<ProductDTO> products = repository.findAll(SORT_BY_PRICE_DESC)
				   .stream()
				   .map(product -> ProductService.convertToDTOFunction.apply(product))
				   .collect(Collectors.toList());
		 ProductService.printProductList("Any", products,"findAllSortedByPrice");
		 return products;
	}

	@Override
	public List<ProductDTO> paginateAndSortProducts(String pageNumber) {
		logger.info("Starting page gneration for page number "+pageNumber+ " with sizePerPage "+sizePerPage);
		handleEmptyPageNumber(pageNumber);
		handleInvalidPageNumber(pageNumber);
		
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), sizePerPage, SORT_BY_PRICE_DESC);
		Page<Product> pageProduct = repository.findAll(pageable);
		return pageProduct.map(ProductService.convertToDTOFunction).getContent();
		
	}
	
	@Override
	public List<ProductDTO> paginateAndSortByMultipleOrderProducts(String pageNumber) {
		logger.info("Starting page gneration for page number "+pageNumber+ " with sizePerPage "+sizePerPage);
		handleEmptyPageNumber(pageNumber);
		handleInvalidPageNumber(pageNumber);
		
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), sizePerPage, SORT_BY_PRICE_AND_NAME_ASC);
		Page<Product> pageProduct = repository.findAll(pageable);
		return pageProduct.map(ProductService.convertToDTOFunction).getContent();
		
	}

	@Override
	public List<ProductDTO> paginateProductsByName(String pageNumber,String name) {
		//sort by ascending of price property
		//forcing the size to be 1 for each badge for demo
		int size  =1;
		logger.info("Starting page gneration for page number "+pageNumber+ " with sizePerPage "+size);
		handleEmptyPageNumber(pageNumber);
		handleInvalidPageNumber(pageNumber);
		handleEmptyPageNumber(name);
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), size, SORT_BY_PRICE_ASC);
		Page<Product> pageProduct = repository.findByName(name,pageable);
		return pageProduct.map(ProductService.convertToDTOFunction).getContent();
	}

}
