package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return UserService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return UserService.addUser(user);
	}
}
