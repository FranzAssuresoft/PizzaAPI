package com.PizzaAPI.Controller.Ingredients;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.PizzaAPI.Controller.IngredientsController;
import com.PizzaAPI.dtos.Ingredients;

public class IngredientsControllerTDD {

	IngredientsController sut = new IngredientsController();
	
	@Test
	@Autowired
	void ShowAllIngredients() {
		ArrayList<Ingredients> expected = this.getListOfIngredients();
		
		ArrayList<Ingredients> result = sut.getAllIngredients();
		
		assertEquals(result, expected);
		
	}
	
	private ArrayList<Ingredients> getListOfIngredients() {
		ArrayList<Ingredients> ingredients = new ArrayList<>();
		
		  Ingredients ingredient = new Ingredients("1L", "Tomate", 2.5);
		  ingredients.add(ingredient);
		  
		  ingredient = new Ingredients("2L", "Queso", 15);
		  ingredients.add(ingredient);
		  
		  ingredient = new Ingredients("3L", "Champiñones", 0.5);
		  ingredients.add(ingredient);
		  
		  
		  return ingredients;
		
	}

}
