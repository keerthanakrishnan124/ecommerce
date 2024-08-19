package com.example.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.MyUser;

public interface CartRepo extends JpaRepository<Cart, Integer>{

	public List<Cart> findByUser(MyUser user);
}
