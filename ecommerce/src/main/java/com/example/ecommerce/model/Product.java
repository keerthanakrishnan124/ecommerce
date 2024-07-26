package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
//	@Column(name="brand")
//	private String brand;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="category")
	private String category;
	
//	@Column(name="release_date")
//	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
//	private Date releaseDate;
	
	@Column(name="available")
	private boolean available;
	
	@Column(name="quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

//	public String getBrand() {
//		return brand;
//	}
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	public Date getReleaseDate() {
//		return releaseDate;
//	}

//	public void setReleaseDate(Date releaseDate) {
//		this.releaseDate = releaseDate;
//	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price="
				+ price + ", category=" + category + ", available=" + available
				+ ", quantity=" + quantity + "]";
	}

	public Product(int id, String name, String description, BigDecimal price, String category, boolean available, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
//		this.releaseDate = releaseDate;
		this.available = available;
		this.quantity = quantity;
	}

	public Product() {
		super();
	}
		
	
	
}
