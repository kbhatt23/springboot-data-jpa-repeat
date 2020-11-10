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
import com.learning.jpa.inheritance_mapping.entities.CompositeCustomerV2;
import com.learning.jpa.inheritance_mapping.entities.CompositeKeyV2;
import com.learning.jpa.inheritance_mapping.repositories.CompositeCustomerRepositoryV2;

@RestController
@RequestMapping("/customers/v2")
public class CompositeCustomerControllerV2 {

	@Autowired
	private CompositeCustomerRepositoryV2 repo;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@PostMapping
	public void createCustomer(@RequestBody CompositeCustomerDTO compositeCustomerDTO) {
		//transforamtion is simple here as same bean is present
		//CompositeCustomerV1 customer = objectMapper.convertValue(compositeCustomerDTO, CompositeCustomerV1.class);
		//force copy construcotr is need as structor of dto and entity are differnet
		CompositeCustomerV2 customer = new CompositeCustomerV2(compositeCustomerDTO) ;
		repo.save(customer);
	}
	
	@GetMapping("/{firstName}/{lastName}/{email}")
	public CompositeCustomerDTO findCustomer(@PathVariable String firstName,@PathVariable String lastName,@PathVariable String email) {
		CompositeKeyV2 compositeKeyV2 = new CompositeKeyV2(firstName, lastName, email);
		
		return repo.findById(compositeKeyV2)
					.map(CompositeCustomerDTO::new)
					.orElseThrow(() -> new RuntimeException("Customer do not exist with id "+compositeKeyV2))
					;
	}
	
	@GetMapping
	public List<CompositeCustomerDTO> findAllCustomers(){
		return repo.findAll()
					.stream()
					.map(CompositeCustomerDTO::new)
					.collect(Collectors.toList());
	}
	
	@GetMapping("/firstName/{firstName}")
	public List<CompositeCustomerDTO> findAllCustomers(@PathVariable String firstName){
		return repo.findByFirstName(firstName)
					.stream()
					.map(CompositeCustomerDTO::new)
					.collect(Collectors.toList());
	}
	
}
