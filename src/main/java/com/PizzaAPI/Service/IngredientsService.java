package com.PizzaAPI.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PizzaAPI.Repositories.IngredientsRepository;
import com.PizzaAPI.dtos.Ingredients;

@Service
public class IngredientsService implements  IIngredientsService{
    
	@Autowired IngredientsRepository ingredientsRepository;
	@Override
	public ArrayList<Ingredients> getAllIngredients() {
		// TODO Auto-generated method stub
		return ingredientsRepository.getAllIngredients();
	}
	
	

}
