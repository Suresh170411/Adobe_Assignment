package com.adobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.exceptions.UserException;
import com.adobe.model.User;
import com.adobe.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public String signUpUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser.getName() + " saved successfully !";
	}

	@Override
	public User getUserById(Integer id) throws UserException {
		return userRepo.findById(id).orElseThrow(() -> new UserException("No user found with the user id : " + id));
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		List<User> userList = userRepo.findAll();
		if (userList.size() == 0) {
			throw new UserException("No users are available !");
		}
		return userList;
	}

	@Override
	public User updateUserById(Integer id, User user) throws UserException {
		User existingUser = userRepo.findById(id).orElseThrow(() -> new UserException("No user found with the user id : " + id));
		
		existingUser.setName(user.getName());
		existingUser.setBio(user.getBio());
		
		return userRepo.save(existingUser);
	}

	@Override
	public String deleteUserById(Integer id) throws UserException {
		userRepo.findById(id).orElseThrow(() -> new UserException("No user found with the user id : " + id));
		userRepo.deleteById(id);
		return "User with id : " + id + " deletedSuccessfully !";
	}

	@Override
	public List<User> getTopFiveActiveUsers() {
		return userRepo.topFiveByPost();
	}

}
