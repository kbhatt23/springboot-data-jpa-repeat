package com.learning.jpa.inheritance_mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.BankAccount;
import com.learning.jpa.inheritance_mapping.entities.services.BankAccountService;
import com.learning.jpa.inheritance_mapping.entities.services.InvalidAccountException;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	
	@GetMapping("/{id}")
	public BankAccount showAccountData(@PathVariable String id) {
		return bankAccountService.findById(id);
	}
	
	@PostMapping
	public void createAccount(@RequestBody BankAccount bankaccount)
	{
		bankAccountService.createOrUpdateAccount(bankaccount);
	}
	
	@GetMapping("/{accountIDFrom}/transfer/{accountIDTo}/amount/{amount}")
	public void transferMoney(@PathVariable String accountIDFrom, @PathVariable String accountIDTo,@PathVariable String amount) throws InvalidAccountException {
		bankAccountService.transfer(accountIDFrom, accountIDTo, amount);
		
		//transaction propagation example
		//bankAccountService.transferMultiTransaction(accountIDFrom, accountIDTo, amount);
	}
}
