package com.PizzaAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PizzaAPI.Repositories.IIngredientsRepository;
import com.PizzaAPI.Repositories.IngredientsRepository;
import com.PizzaAPI.dtos.Ingredients;

@Service
public class IngredientsService implements  IIngredientsService{
    
    @Autowired 
    IIngredientsRepository ingredientsRepository;
    
	public IngredientsService(IIngredientsRepository ingredientRepository)
	{
		this.ingredientsRepository = ingredientRepository;
	}
	
	@Override
	public List<Ingredients> getAllIngredients() {
		return ingredientsRepository.getAllIngredients();
	}
	
}
