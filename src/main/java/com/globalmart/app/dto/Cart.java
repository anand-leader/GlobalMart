package com.globalmart.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/************************************************************************************
 * @author Abhishek Kumar Jaiswal
 * 
 *         Description : It is a POJO class for Cart. All the entity and
 *         their respective mappings are defined here.
 * 
 *         
 * 
 *         Created Date 02-AUG-2022
 ************************************************************************************/


@Entity
public class Cart {

	@Id
	private Integer cartId;
	private Integer productQuantity;
	private Double cartPrice;

	@ManyToMany
	private List<Product> products = new ArrayList<>();

	public Cart() {
		super();
	}

	public Cart(Integer cartId, Integer productQuantity, Double cartPrice, List<Product> products) {
		super();
		this.cartId = cartId;
		this.productQuantity = productQuantity;
		this.cartPrice = cartPrice;
		this.products = products;
	}

	public Integer getCartId() {
		return cartId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public Double getCartPrice() {
		return cartPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


}