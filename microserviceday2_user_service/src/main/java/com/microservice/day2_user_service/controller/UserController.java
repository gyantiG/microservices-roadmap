package com.microservice.day2_user_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.day2_user_service.model.User;

@RestController
@RequestMapping("/day2/users")
public class UserController {
	
	List<User> users=new ArrayList<>();
	
	@GetMapping()
	public List<User> getUsers() {
		return users;	
	}
	
	@PostMapping()
	public String createUser(@RequestBody User user) {
		users.add(user);
		return "User created successfully...";	
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;	
	}
	
	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User updateUser) {
		for(User user:users) {
			
			if(user.getId()==id) {
				System.out.println(updateUser.getName());
				System.out.println(updateUser.getCity());
				user.setName(updateUser.getName());
				user.setCity(updateUser.getCity());
				
				return "User updated successfully...";
			}
		}
			
		return "User not found";
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		boolean removed=users.removeIf(user->user.getId()==id);
		if(removed) {
			return "User removed successfully...";
		}
		return "User not found";	
	}
	
	

}
