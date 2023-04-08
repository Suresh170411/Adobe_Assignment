package com.adobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import com.adobe.model.User;
import com.adobe.repository.UserRepository;

@RestController
public class LoginController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<User> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		User person = userRepo.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		 
		return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
	}
}
