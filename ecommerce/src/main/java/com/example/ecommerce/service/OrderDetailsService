package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.MyUser;
import com.example.ecommerce.model.OrderDetail;
import com.example.ecommerce.model.OrderDetailResponse;
import com.example.ecommerce.model.OrderInput;
import com.example.ecommerce.model.OrderProductQuantity;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductResponses;
import com.example.ecommerce.repo.OrderRepo;
import com.example.ecommerce.repo.ProductRepo;
import com.example.ecommerce.repo.UserRepo;

@Service
public class OrderDetailsService {
	
	private static final String ORDER_PLACED="Placed";
	
	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UserRepo userRepo;

	public List<OrderDetailResponse> placeOrder(OrderInput orderInput) {
		
		List<OrderProductQuantity> orderQuantity=orderInput.getOrderQuantity();
		String currentuser=JwtService.CURRENT_USER;
		MyUser user=userRepo.findByUsername(currentuser).get();
		
		List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
		
		for(OrderProductQuantity o:orderQuantity) {
			Product product=productRepo.findById(o.getProductId()).get();
			
			
			  int newQuantity = product.getQuantity() - o.getProductQuantity();
	            if (newQuantity < 0) {
	                throw new RuntimeException("Insufficient stock for product: " + product.getName());
	            }
	            product.setQuantity(newQuantity);
	            productRepo.save(product);
	            
			OrderDetail orderDetails=new OrderDetail(
					orderInput.getOrdername(),
					ORDER_PLACED,
					o.getProductQuantity(),
					product.getPrice() * o.getProductQuantity(),
					user.getAddress(),
					user.getPhone(),
					product,
					user);
					
			 repo.save(orderDetails);
			 
			 OrderDetailResponse.ProductResponse productResponse = new OrderDetailResponse.ProductResponse();
			 productResponse.setName(product.getName());
			 productResponse.setDescription(product.getDescription());
			 productResponse.setPrice(product.getPrice());
			 
			 OrderDetailResponse response=new OrderDetailResponse();
			 response.setOrderName(orderDetails.getOrderername());
			 response.setOrderStatus(orderDetails.getOrderStatus());
		     response.setOrderAmount(orderDetails.getOrderAmount());
		     response.setFullAddress(orderDetails.getFullAddress());
		     response.setContactNumber(orderDetails.getContactNumber());
		     response.setProduct(productResponse);
		     
		     orderDetailResponses.add(response);
		}
		
		return orderDetailResponses;
	}

	public List<ProductResponses> getMyOrder() {
		String currentuser=JwtService.CURRENT_USER;
		Optional<MyUser> user=userRepo.findByUsername(currentuser);
		 if (!user.isPresent()) {
		        throw new RuntimeException("User not found");
		    }
		List<OrderDetail> details=repo.findByUser(user);
		List<ProductResponses> responses=new ArrayList<>();
		
		for(OrderDetail o:details) {
			ProductResponses.ProductInfo productinfo=new ProductResponses.ProductInfo();
			productinfo.setProductId(o.getProduct().getId());
			productinfo.setName(o.getProduct().getName());
			productinfo.setDescription(o.getProduct().getDescription());
			productinfo.setPrice(o.getProduct().getPrice());
			
			ProductResponses response=new ProductResponses();
			response.setOrdererName(o.getOrderername());
			response.setProductQuantity(o.getOrderQuantity());
			response.setAmount(o.getOrderAmount());
			response.setOrderStatus(o.getOrderStatus());
			response.setProductInfo(productinfo);
			
			responses.add(response);
		}
		
		return responses;
		
	}

	public List<OrderDetail> getAllOrders() {
	
	return repo.findAll();
		
	}

}
