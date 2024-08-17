package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.OrderDetail;
import com.example.ecommerce.model.OrderDetailResponse;
import com.example.ecommerce.model.OrderInput;
import com.example.ecommerce.model.ProductResponses;
import com.example.ecommerce.service.OrderDetailsService;


@RestController
public class OrderController {

	@Autowired
	private OrderDetailsService orderetailsService;
	
	
	@PostMapping("/placeorder")
	public List<OrderDetailResponse> placeOrder(@RequestBody OrderInput orderInput) {
		return orderetailsService.placeOrder(orderInput);
	}
	
	@GetMapping("/myorders")
	public List<ProductResponses> getMyOrder() {
		return orderetailsService.getMyOrder();
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/allorders")
	public List<OrderDetail> getAllOrders() {
		return orderetailsService.getAllOrders();
	}
	
}
