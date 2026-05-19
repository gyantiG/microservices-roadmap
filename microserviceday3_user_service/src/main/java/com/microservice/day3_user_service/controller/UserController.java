package com.microservice.day3_user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.day3_user_service.model.User;
import com.microservice.day3_user_service.service.UserService;

@RestController
@RequestMapping("/day3/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public List<User> getUsers() {
		return userService.getUsers();	
	}
	
	@PostMapping()
	public String addUser(@RequestBody User user) {
		if(userService.createUser(user) != null)
			return "User created successfully...";
		return "User not created";	
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return userService.getById(id);	
	}
	
	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User updateUser) {	
		return userService.updateUser(id, updateUser);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);	
	}	
}
