package com.example.ecommerce.model;

public class OrderDetailResponse {

    private String orderName;
    private String orderStatus;
    private double orderAmount;
    private String fullAddress;
    private String contactNumber;
    private ProductResponse product;
    
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
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
	public ProductResponse getProduct() {
		return product;
	}
	public void setProduct(ProductResponse product) {
		this.product = product;
	}
    
	 public static class ProductResponse {
	        private String name;
	        private String description;
	        private double price;
	        
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
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}

	       
	    }
	
}
