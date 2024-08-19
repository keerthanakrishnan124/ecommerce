package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartProductResponse;
import com.example.ecommerce.model.ViewCart;
import com.example.ecommerce.model.MyUser;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.CartRepo;
import com.example.ecommerce.repo.ProductRepo;
import com.example.ecommerce.repo.UserRepo;

@Service
public class CartService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CartRepo cartRepo;

	 public ViewCart addToCart(int id) {
	        Product product = productRepo.findById(id)
	                                     .orElseThrow(() -> new NoSuchElementException("Product not found"));
	        
	        String username = JwtService.CURRENT_USER;
	        MyUser user = userRepo.findByUsername(username)
	                              .orElseThrow(() -> new NoSuchElementException("User not found"));
	        
	        Cart cart = new Cart(product, user);
	        cartRepo.save(cart);
	        
	        return mapToViewCart(cart);
	    }

	public List<ViewCart> viewCart() {
        String username = JwtService.CURRENT_USER;
        MyUser user = userRepo.findByUsername(username)
                              .orElseThrow(() -> new NoSuchElementException("User not found"));
        
        List<Cart> cartList = cartRepo.findByUser(user);
        List<ViewCart> response = new ArrayList<>();
        
        for (Cart cart : cartList) {
            response.add(mapToViewCart(cart));
        }
        
        return response;
    }

	public List<ViewCart> deleteCartItem(int cartId) {
		cartRepo.deleteById(cartId);
	
		return viewCart();
	}

	
	 private ViewCart mapToViewCart(Cart cart) {
	        ViewCart viewCart = new ViewCart();
	        viewCart.setId(cart.getId());
	        
	        Product product = cart.getProduct();
	        CartProductResponse productResponse = new CartProductResponse();
	        productResponse.setId(product.getId());
	        productResponse.setName(product.getName());
	        productResponse.setDescription(product.getDescription());
	        productResponse.setCategory(product.getCategory());
	        productResponse.setPrice(product.getPrice());
	        
	        viewCart.setProduct(productResponse);
	        return viewCart;
	    }
}
