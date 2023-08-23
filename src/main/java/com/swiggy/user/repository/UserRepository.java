package com.swiggy.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.user.entity.SwiggyUsers;

@Repository
public interface UserRepository extends JpaRepository<SwiggyUsers, String>{
	
	
     
}
