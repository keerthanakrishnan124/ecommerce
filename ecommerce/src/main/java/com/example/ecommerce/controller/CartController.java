package com.example.ecommerce.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.ViewCart;
import com.example.ecommerce.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("addcart/{productId}")
	public ResponseEntity<ViewCart> addToCart(@PathVariable int productId) {
        try {
            ViewCart viewCart = cartService.addToCart(productId);
            return ResponseEntity.ok(viewCart);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/mycart")
	 public ResponseEntity<List<ViewCart>> viewCart() {
        try {
            List<ViewCart> viewCartList = cartService.viewCart();
            return ResponseEntity.ok(viewCartList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/deletecart/{cartId}")
	public ResponseEntity<List<ViewCart>> deleteCartItem(@PathVariable int cartId) {
        try {
            List<ViewCart> viewCartList = cartService.deleteCartItem(cartId);
            return ResponseEntity.ok(viewCartList);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
	
	
	
}
