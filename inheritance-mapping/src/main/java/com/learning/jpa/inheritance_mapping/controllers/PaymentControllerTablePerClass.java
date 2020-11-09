package com.learning.jpa.inheritance_mapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.ChequeTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.CreditCardTablePerClass;
import com.learning.jpa.inheritance_mapping.repositories.PaymentRepositoryTablePerClass;

@RestController
@RequestMapping("/payment/table-per-class")
public class PaymentControllerTablePerClass {
	@Autowired
	private PaymentRepositoryTablePerClass reposiotry;
	
	@PostMapping("/credit-card")
	public void createPaymentCreditCard(@RequestBody CreditCardTablePerClass payment) {
		reposiotry.save(payment);
	}
	
	@PostMapping("/cheque")
	public void createPaymentCheque(@RequestBody ChequeTablePerClass payment) {
		reposiotry.save(payment);
	}
	
	@GetMapping("/credit-card")
	public List<CreditCardTablePerClass> findAllCreditCards(){
		return reposiotry.findAllCreditCards();
	}
	
	@GetMapping("/cheque")
	public List<ChequeTablePerClass> findAllCheque(){
		return reposiotry.findAllCheques();
	}
}
