package com.learning.jpa.inheritance_mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.jpa.inheritance_mapping.entities.CompositeCustomerDTO;
import com.learning.jpa.inheritance_mapping.entities.CompositeCustomerV1;
import com.learning.jpa.inheritance_mapping.entities.CompositeKeyV1;
import com.learning.jpa.inheritance_mapping.repositories.CompositeCustomerRepositoryV1;

@RestController
@RequestMapping("/customers/v1")
public class CompositeCustomerControllerV1 {

	@Autowired
	private CompositeCustomerRepositoryV1 repo;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@PostMapping
	public void createCustomer(@RequestBody CompositeCustomerDTO compositeCustomerDTO) {
		//transforamtion is simple here as same bean is present
		CompositeCustomerV1 customer = objectMapper.convertValue(compositeCustomerDTO, CompositeCustomerV1.class);
		repo.save(customer);
	}
	
	@GetMapping("/{firstName}/{lastName}/{email}")
	public CompositeCustomerDTO findCustomer(@PathVariable String firstName,@PathVariable String lastName,@PathVariable String email) {
		CompositeKeyV1 compositeKeyV1 = new CompositeKeyV1(firstName, lastName, email);
		
		return repo.findById(compositeKeyV1)
					.map(customer -> objectMapper.convertValue(customer, CompositeCustomerDTO.class))
					.orElseThrow(() -> new RuntimeException("Customer do not exist with id "+compositeKeyV1))
					;
	}
	
	@GetMapping
	public List<CompositeCustomerDTO> findAllCustomers(){
		return repo.findAll()
					.stream()
					.map(customer -> objectMapper.convertValue(customer, CompositeCustomerDTO.class))
					.collect(Collectors.toList());
	}
	
	@GetMapping("/firstName/{firstName}")
	public List<CompositeCustomerDTO> findAllCustomers(@PathVariable String firstName){
		return repo.findByFirstName(firstName)
					.stream()
					.map(customer -> objectMapper.convertValue(customer, CompositeCustomerDTO.class))
					.collect(Collectors.toList());
	}
	
}
