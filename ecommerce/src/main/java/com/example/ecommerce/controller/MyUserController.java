package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.MyUser;
import com.example.ecommerce.model.UserProjection;
import com.example.ecommerce.service.MyUserService;



@RestController
public class MyUserController {
	
	@Autowired
	MyUserService myUserService;

	@GetMapping("admin/getusers")
	public ResponseEntity<List<UserProjection>> getUserDetails(){
		
		return new ResponseEntity<>(myUserService.getUserDetails(),HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public MyUser register(@RequestBody MyUser user) {
		return myUserService.register(user);
	}
	
	
}
