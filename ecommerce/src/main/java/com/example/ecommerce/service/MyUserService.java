package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.MyUser;
import com.example.ecommerce.model.UserProjection;
import com.example.ecommerce.repo.UserRepo;



@Service
public class MyUserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserProjection> getUserDetails() {
		return userRepo.findUserDetails();
	}

	public MyUser register(MyUser user) {
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
