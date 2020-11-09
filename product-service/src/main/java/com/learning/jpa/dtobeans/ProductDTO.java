package com.learning.jpa.dtobeans;

public class ProductDTO {
	private Integer id;

	private String name;
	
	private String desc;
	
	private Double price;

	public ProductDTO() {
	}

	public ProductDTO(Integer id,String name, String desc, Double price) {
		this.id=id;
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
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
