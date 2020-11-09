package com.learning.jpa.inheritance_mapping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer>{

}
