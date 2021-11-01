package com.PizzaAPI.service;

import com.PizzaAPI.dtos.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public interface IUserService {
    User createUser(User user) throws InterruptedException, ExecutionException;

    User getUser(String id) throws InterruptedException, ExecutionException;

    Boolean deleteUser(String id);

    List<User> getAllUsers() throws InterruptedException, ExecutionException;

    User updateUser(User User);
}
