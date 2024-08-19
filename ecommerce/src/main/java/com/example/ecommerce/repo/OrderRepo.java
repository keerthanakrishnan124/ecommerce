package com.example.ecommerce.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.MyUser;
import com.example.ecommerce.model.OrderDetail;

public interface OrderRepo extends JpaRepository<OrderDetail, Integer>{
	public List<OrderDetail> findByUser(Optional<MyUser> user);
}
