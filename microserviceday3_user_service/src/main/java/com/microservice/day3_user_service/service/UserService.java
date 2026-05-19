package com.microservice.day3_user_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.day3_user_service.model.User;

@Service
public class UserService {

	List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public String createUser(User user) {
		users.add(user);
		return "User created successfully...";
	}

	public User getById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public String updateUser(int id, User updateUser) {
		for (User user : users) {

			if (user.getId() == id) {
				System.out.println(updateUser.getName());
				System.out.println(updateUser.getCity());
				user.setName(updateUser.getName());
				user.setCity(updateUser.getCity());

				return "User updated successfully...";
			}
		}

		return "User not found";
	}

	public String deleteUser(int id) {
		boolean removed = users.removeIf(user -> user.getId() == id);
		if (removed) {
			return "User removed successfully...";
		}
		return "User not found";
	}

}
