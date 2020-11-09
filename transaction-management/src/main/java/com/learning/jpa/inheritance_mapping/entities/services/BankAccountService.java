package com.learning.jpa.inheritance_mapping.entities.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learning.jpa.inheritance_mapping.entities.BankAccount;
import com.learning.jpa.inheritance_mapping.repositories.BankAccountRepository;

@Service
public class BankAccountService {
	int count =0;
	

	@Autowired
	private BankAccountRepository repository;
	//assuming ampunt will be feasile to deduct from account
	
	@Transactional
	public void transfer(String accountIDFrom, String accountIDTo , String amountStr) {
		long amount = Long.parseLong(amountStr);
		BankAccount accountFrom = findById(accountIDFrom);
		
		BankAccount accountTo = findById(accountIDTo);
		
		//trying to transfer more than available balance
		if(accountFrom.getBalance() < amount) {
			throw new RuntimeException("Account "+accountIDFrom + " do not have enough balance to transfer requested amount "+amount);
		}
		accountTo.setBalance(accountTo.getBalance()+amount);
		repository.save(accountTo);
		
		//fake expetion
		/*
		 * if(true) { throw new RuntimeException("Account "+accountIDFrom +
		 * " do not have enough balance to transfer requested amount "+amount); }
		 */
		
		accountFrom.setBalance(accountFrom.getBalance()-amount);
		repository.save(accountFrom);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void transferMultiTransaction(String accountIDFrom, String accountIDTo, String amountStr)
			throws InvalidAccountException {
		long amount = Long.parseLong(amountStr);
		BankAccount accountFrom = findById(accountIDFrom);

		BankAccount accountTo = findById(accountIDTo);
		// trying to transfer more than available balance
		if (accountFrom.getBalance() < amount) {
			throw new RuntimeException(
					"Account " + accountIDFrom + " do not have enough balance to transfer requested amount " + amount);
		}

		accountTo.setBalance(accountTo.getBalance() + amount);
		repository.save(accountTo);

		accountFrom.setBalance(accountFrom.getBalance() - amount);
		createOrUpdateAccountNewTransaction(accountFrom);

	}


	public BankAccount findById(String accountID) {
		Integer idInt = generateID(accountID);
		return repository.findById(idInt).orElseThrow(idNotPresentSupplier(accountID));
	}
	
	@Transactional
	public void createOrUpdateAccount(BankAccount account) {
		repository.save(account);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createOrUpdateAccountNewTransaction(BankAccount account) throws InvalidAccountException{
		boolean error = true;
		if(error)
			throw new InvalidAccountException("invalid account "+account.getId());
		repository.save(account);
	}
	
	
	public Integer generateID(String idStr) {
		return Integer.parseInt(idStr);
	}
	
	public Supplier<RuntimeException> idNotPresentSupplier(String id){
		String message = "idNotPresentSupplier: Account do not exist with ID "+id;
		return () -> new RuntimeException(message);
	}
}
