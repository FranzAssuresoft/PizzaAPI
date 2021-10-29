package com.PizzaAPI.controller;
import com.PizzaAPI.service.IUserService;
import com.PizzaAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.PizzaAPI.dtos.User;

@RestController
public class UserController {

	private final IUserService iUserService;

	@Autowired
	public UserController(UserService userService) {
		this.iUserService = userService;
	}

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
		return iUserService.createUser(user);
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam String id) throws InterruptedException, ExecutionException {
		return iUserService.getUser(id);
	}

	@GetMapping("/getAllUser")
	public List<User> getUser() throws InterruptedException, ExecutionException {
		return iUserService.getAllUser();
	}
	
<<<<<<< HEAD
	@PutMapping("/update")
	public User updateUser(@RequestBody User User) throws InterruptedException, ExecutionException {
		return iUserService.updateUser(User);
	}
	
	@DeleteMapping("/delete")
	public Boolean deleteUser(@RequestBody String id) throws InterruptedException, ExecutionException {
=======
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User User) throws InterruptedException, ExecutionException {
		return iUserService.updateUser(User);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestBody String id) throws InterruptedException, ExecutionException {
>>>>>>> 3e286069ba42b4e4dee89f03a2cc15542276986b
		return iUserService.deleteUser(id);
	}
}
