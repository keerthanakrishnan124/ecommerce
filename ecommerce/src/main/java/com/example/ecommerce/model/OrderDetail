package com.example.ecommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String orderername;
	private String orderStatus;
	private int orderQuantity;
	
	private double orderAmount;
	private String fullAddress;
	private String contactNumber;
	
	@OneToOne
	private Product product;
	
	@OneToOne
	private MyUser user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderername() {
		return orderername;
	}

	public void setOrderername(String orderername) {
		this.orderername = orderername;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public OrderDetail(String orderername, String orderStatus, int orderQuantity, double orderAmount,
			String fullAddress, String contactNumber, Product product, MyUser user) {
		super();
		this.orderername = orderername;
		this.orderStatus = orderStatus;
		this.orderQuantity = orderQuantity;
		this.orderAmount = orderAmount;
		this.fullAddress = fullAddress;
		this.contactNumber = contactNumber;
		this.product = product;
		this.user = user;
	}

	public OrderDetail() {
		super();
	}
}
