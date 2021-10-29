package com.PizzaAPI.repositories;

import com.PizzaAPI.dtos.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface IUserRepository {
    String createUser(User user) throws InterruptedException, ExecutionException;

    User getUser(String id) throws InterruptedException, ExecutionException;

    List<User> getAllUser() throws InterruptedException, ExecutionException;

    String deleteUser(String id);

    String updateUser(User User);
}
