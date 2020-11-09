package com.learning.jpa.inheritance_mapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.ChequeJoined;
import com.learning.jpa.inheritance_mapping.entities.CreditCardJoined;
import com.learning.jpa.inheritance_mapping.repositories.PaymentRepositoryJoined;

@RestController
@RequestMapping("/payment/joined")
public class PaymentControllerJoined {
	@Autowired
	private PaymentRepositoryJoined reposiotry;
	
	@PostMapping("/credit-card")
	public void createPaymentCreditCard(@RequestBody CreditCardJoined payment) {
		reposiotry.save(payment);
	}
	
	@PostMapping("/cheque")
	public void createPaymentCheque(@RequestBody ChequeJoined payment) {
		reposiotry.save(payment);
	}
	
	@GetMapping("/credit-card")
	public List<CreditCardJoined> findAllCreditCards(){
		return reposiotry.findAllCreditCards();
	}
	
	@GetMapping("/cheque")
	public List<ChequeJoined> findAllCheque(){
		return reposiotry.findAllCheques();
	}
}
