package com.PizzaAPI.config;

import com.PizzaAPI.controller.UserController;
import com.PizzaAPI.firebase.FirebaseInitializer;
import com.PizzaAPI.service.IUserService;
import com.google.cloud.firestore.Firestore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class SpringContext {
    @Bean
    Firestore firestore() throws IOException {
        return new FirebaseInitializer().getFirestore();
    }
}