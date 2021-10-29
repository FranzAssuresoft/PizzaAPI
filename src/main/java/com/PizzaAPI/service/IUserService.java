package com.PizzaAPI.service;

import com.PizzaAPI.dtos.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface IUserService {
    User createUser(User user) throws InterruptedException, ExecutionException;

    User getUser(String id) throws InterruptedException, ExecutionException;

    Boolean deleteUser(String id);

    User updateUser(User User);
}
