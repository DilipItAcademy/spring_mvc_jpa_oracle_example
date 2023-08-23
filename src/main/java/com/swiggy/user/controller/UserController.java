package com.swiggy.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.user.entity.SwiggyUsers;
import com.swiggy.user.request.UserRegisterRequest;
import com.swiggy.user.response.UserRegisterResponse;
import com.swiggy.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public String registerUserDetails(@RequestBody UserRegisterRequest request) {
		// Controller -> Service and From Service receiving Result
		String response = userService.registerUserDetails(request);
		return response;
	}

	// Fetch user Details of one Person by email ID
	@GetMapping("/fetch")
	public UserRegisterResponse getUserDetails() {
		String email = "Dilip@gmail.com";
		UserRegisterResponse response = userService.getUserDetails(email);
		return response;
	}

	// Loading all User Details
	@GetMapping("/fetch/all")
	public List<SwiggyUsers> getAllUserDetails() {
		return userService.getAllUserDetails();
	}

}
