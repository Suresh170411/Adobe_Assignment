package com.adobe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.exceptions.UserException;
import com.adobe.model.User;
import com.adobe.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/users")
	public ResponseEntity<String> signUpUserHandler(@RequestBody User user){
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return new ResponseEntity<String>(userService.signUpUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable ("id") Integer id) throws UserException{
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserByIdHandler(@RequestBody User user, @PathVariable ("id") Integer id) throws UserException{
		return new ResponseEntity<User>(userService.updateUserById(id, user), HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUserByIdHandler(@PathVariable ("id") Integer id) throws UserException{
		return new ResponseEntity<String>(userService.deleteUserById(id),HttpStatus.OK);
	}
	
	@GetMapping("/analytics/users")
	public ResponseEntity<List<User>> getAllUserHandler() throws UserException{
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	
	
}
