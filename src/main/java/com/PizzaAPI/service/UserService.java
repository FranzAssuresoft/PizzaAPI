package com.PizzaAPI.service;
import java.util.concurrent.ExecutionException;

import com.PizzaAPI.repositories.IUserRepository;
import com.PizzaAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.PizzaAPI.dtos.User;

@Service
public class UserService implements IUserService {

	private final IUserRepository iUserRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.iUserRepository = userRepository;
	}

	@Override
	public String createUser(User user) throws InterruptedException, ExecutionException {
		return iUserRepository.createUser(user);
	}

	@Override
	public User getUser(String id) throws InterruptedException, ExecutionException {
		return iUserRepository.getUser(id);
	}

	@Override
	public String deleteUser(String id) {
		return null;
	}

	@Override
	public String updateUser(User User) {
		return null;
	}
}
