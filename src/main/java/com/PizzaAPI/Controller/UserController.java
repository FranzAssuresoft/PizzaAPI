package com.PizzaAPI.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.PizzaAPI.Service.userService;
import com.PizzaAPI.dtos.User;

@RestController
public class UserController {

	public userService UserService;
	
	public UserController(userService UserService) {
		this.UserService = UserService;
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
		return UserService.createUser(user);
	}
	
	@GetMapping("/get")
	public User getUser(@RequestParam String id) throws InterruptedException, ExecutionException {
		return UserService.getUser(id);
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody User User) throws InterruptedException, ExecutionException {
		return UserService.updateUser(User);
	}
	
	@DeleteMapping("/delete")
	public String deleteUser(@RequestBody String id) throws InterruptedException, ExecutionException {
		return UserService.deleteUser(id);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testGetEndpoint(){
		return ResponseEntity.ok("Test get endpoint is working");
	}	
}
