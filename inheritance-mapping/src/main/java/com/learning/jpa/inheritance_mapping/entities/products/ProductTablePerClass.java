package com.learning.jpa.inheritance_mapping.entities.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
//product subclassing is possible-> keeping all common columns here
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProductTablePerClass {
	
	@TableGenerator(name = "sample_table_generator", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "sample_table_generator")
	private Integer id;
	
	private String name;
	
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
