package com.example.ecommerce.model;

public class ViewCart {
	
	private int id;
	private CartProductResponse product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CartProductResponse getProduct() {
		return product;
	}
	public void setProduct(CartProductResponse product) {
		this.product = product;
	}	

}
