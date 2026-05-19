package com.microservice.day1_user_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day1")
public class HelloController {
	
	@GetMapping("/hello")
	public String getHello() {
		return "hi";	
	}
	
	// task 1
	@GetMapping("/{name}")
	public String getName(@PathVariable String name) {
		return "Your name is "+name;
	}
	
	@GetMapping("/city")
	public String getYourCity() {
		return "your city is Pune";
	}
	
	@GetMapping("/course")
	public List<String> getYourCourse() {
		return List.of("BCA","MCA","B-tech");
	}

}
