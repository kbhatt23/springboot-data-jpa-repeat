package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.jpa.inheritance_mapping.entities.ChequeJoined;
import com.learning.jpa.inheritance_mapping.entities.ChequeTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.CreditCardJoined;
import com.learning.jpa.inheritance_mapping.entities.CreditCardTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.PaymentJoined;
@Repository
public interface PaymentRepositoryJoined extends CrudRepository<PaymentJoined, Integer>{

	@Query(value = "select s from CreditCardJoined s")
	public List<CreditCardJoined> findAllCreditCards();
	
	@Query(value = "select s from ChequeJoined s")
	public List<ChequeJoined> findAllCheques();
}
