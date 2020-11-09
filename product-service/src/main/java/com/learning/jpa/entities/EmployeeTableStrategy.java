package com.learning.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
//table expected is employee_table_strategy -> only column name is manipulated
@Entity
public class EmployeeTableStrategy {
	@TableGenerator(name = "employee_table_strategy_generator" ,  table = "id_gen",pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_table_strategy_generator")
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
