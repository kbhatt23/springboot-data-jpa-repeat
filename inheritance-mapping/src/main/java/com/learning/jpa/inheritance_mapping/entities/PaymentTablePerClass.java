package com.learning.jpa.inheritance_mapping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
//automatic table name will be payment_single_table
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
@Entity
//need to define inheritance strategy
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//this table need not exist, as all common columns will be present in all the subtypes tables
public class PaymentTablePerClass {
	@TableGenerator(name = "employee_table_strategy_generator" ,  table = "id_gen",pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_table_strategy_generator")
	private Integer id;
	
	private Double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
