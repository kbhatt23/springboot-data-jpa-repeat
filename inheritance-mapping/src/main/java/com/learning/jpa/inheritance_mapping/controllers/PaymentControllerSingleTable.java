package com.learning.jpa.inheritance_mapping.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.ChequeSingleTable;
import com.learning.jpa.inheritance_mapping.entities.CreditCardSingleTable;
import com.learning.jpa.inheritance_mapping.repositories.PaymentRepositorySingleTable;

@RestController
@RequestMapping("/payment/single")
public class PaymentControllerSingleTable {
	@Autowired
	private PaymentRepositorySingleTable reposiotry;
	
	@PostMapping("/credit-card")
	public void createPaymentCreditCard(@RequestBody CreditCardSingleTable payment) {
		reposiotry.save(payment);
	}
	
	@PostMapping("/cheque")
	public void createPaymentCheque(@RequestBody ChequeSingleTable payment) {
		reposiotry.save(payment);
	}
	
	@GetMapping("/credit-card")
	public List<CreditCardSingleTable> findAllCreditCards(){
		return reposiotry.findAllByModeTypeSQL("credit-card")
					.stream()
					.map(a -> (CreditCardSingleTable)a)
					.collect(Collectors.toList())
				;
	}
	
	@GetMapping("/cheque")
	public List<ChequeSingleTable> findAllCheque(){
		return reposiotry.findAllByModeTypeSQL("cheque")
					.stream()
					.map(a -> (ChequeSingleTable)a)
					.collect(Collectors.toList())
				;
	}
}
