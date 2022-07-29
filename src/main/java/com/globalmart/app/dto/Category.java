package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private Integer categoryId;
	private String name;
	private String description;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer categoryId, String name, String description, Product product) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
//		this.product = product;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
//
//	public Product getProduct() {
//		return product;
//	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

}
