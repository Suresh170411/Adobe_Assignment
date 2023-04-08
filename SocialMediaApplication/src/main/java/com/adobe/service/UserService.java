package com.adobe.service;

import java.util.List;

import com.adobe.exceptions.UserException;
import com.adobe.model.User;

public interface UserService {

	public String signUpUser(User user);

	public User getUserById(Integer id) throws UserException;

	public List<User> getAllUsers() throws UserException;

	public User updateUserById(Integer id, User user) throws UserException;

	public String deleteUserById(Integer id) throws UserException;

	public List<User> getTopFiveActiveUsers();
}
