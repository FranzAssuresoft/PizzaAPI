package com.PizzaAPI.service;

import com.PizzaAPI.dtos.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public interface IUserService {
    String createUser(User user) throws InterruptedException, ExecutionException;

    User getUser(String id) throws InterruptedException, ExecutionException;

    List<User> getAllUser() throws InterruptedException, ExecutionException;

    String deleteUser(String id);

    String updateUser(User User);
}
