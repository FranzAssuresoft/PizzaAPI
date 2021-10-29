package com.PizzaAPI.service;

import com.PizzaAPI.dtos.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public interface IUserService {
    User createUser(User user) throws InterruptedException, ExecutionException;

    User getUser(String id) throws InterruptedException, ExecutionException;

<<<<<<< HEAD
    Boolean deleteUser(String id);
=======
    List<User> getAllUser() throws InterruptedException, ExecutionException;

    String deleteUser(String id);
>>>>>>> 3e286069ba42b4e4dee89f03a2cc15542276986b

    User updateUser(User User);
}
