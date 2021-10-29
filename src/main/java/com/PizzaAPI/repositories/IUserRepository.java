package com.PizzaAPI.repositories;

import com.PizzaAPI.dtos.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface IUserRepository {
    User createUser(User user) throws InterruptedException, ExecutionException;

    User getUser(String id) throws InterruptedException, ExecutionException;

    List<User> getAllUsers() throws InterruptedException, ExecutionException;

    Boolean deleteUser(String id);

    User updateUser(User User);
}
