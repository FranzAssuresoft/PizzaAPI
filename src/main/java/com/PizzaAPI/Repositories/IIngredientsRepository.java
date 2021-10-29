package com.PizzaAPI.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.PizzaAPI.dtos.Ingredients;


public interface IIngredientsRepository {
	
	public List<Ingredients> getAllIngredients();

}
