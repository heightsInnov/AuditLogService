package com.babatunde.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babatunde.model.User;
import com.babatunde.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		return userService.findUserById(id);
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
