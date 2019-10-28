package com.babatunde.service;

import java.util.List;

import com.babatunde.model.User;

public interface UserService {
	
	public User addUser(User user);
	
	public List<User> findAllUsers();
	
	public User findUserById(String id);

}
