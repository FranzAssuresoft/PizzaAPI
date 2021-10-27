package com.PizzaAPI.Repositories;

import java.util.ArrayList;

import com.PizzaAPI.dtos.Ingredients;


public interface IIngredientsRepository {
	
	public ArrayList<Ingredients> getAllIngredients();

}
