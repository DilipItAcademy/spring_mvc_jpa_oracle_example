package com.swiggy.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swiggy.user.entity.SwiggyUsers;
import com.swiggy.user.repository.UserRepository;
import com.swiggy.user.request.UserRegisterRequest;
import com.swiggy.user.response.UserRegisterResponse;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public String registerUserDetails(UserRegisterRequest registerRequest) {
		// Mapping data to Entity Object
		SwiggyUsers user = new SwiggyUsers();
		user.setEmail(registerRequest.getEmail());
		user.setMobile(registerRequest.getMobile());
		user.setName(registerRequest.getName());
		user.setPassword(registerRequest.getPassword());
		repository.save(user);
		return "User Registered Successfully";
	}

	public UserRegisterResponse getUserDetails(String email) {
		SwiggyUsers user = repository.findById(email).get();
		UserRegisterResponse response = new UserRegisterResponse();
		response.setEmail(user.getEmail());
		response.setMobile(user.getMobile());
		response.setName(user.getName());
		return response;
	}

	public List<SwiggyUsers>  getAllUserDetails() {
		return  repository.findAll();
	}
}
