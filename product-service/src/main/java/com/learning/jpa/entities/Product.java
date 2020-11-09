package com.learning.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//automatic table name will be 'product'
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//creates column witn 'name'
	@Column(length = 30, nullable = false)
	private String name;
	
	//have made desc intentionally to describle column name annoation
	@Column(length = 250,name = "description")
	private String desc;
	
	private Double price;

	public Product() {
	}

	public Product(String name, String desc, Double price) {
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}
	
	
	
}
