package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.jpa.inheritance_mapping.entities.ChequeTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.CreditCardTablePerClass;
import com.learning.jpa.inheritance_mapping.entities.PaymentTablePerClass;
@Repository
public interface PaymentRepositoryTablePerClass extends CrudRepository<PaymentTablePerClass, Integer>{

	@Query(value = "select s from CreditCardTablePerClass s")
	public List<CreditCardTablePerClass> findAllCreditCards();
	
	@Query(value = "select s from ChequeTablePerClass s")
	public List<ChequeTablePerClass> findAllCheques();
}
