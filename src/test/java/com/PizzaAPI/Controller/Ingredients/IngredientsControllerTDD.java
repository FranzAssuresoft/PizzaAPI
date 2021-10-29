package com.PizzaAPI.Controller.Ingredients;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.PizzaAPI.Controller.IngredientsController;
import com.PizzaAPI.Service.IIngredientsService;
import com.PizzaAPI.dtos.Ingredients;

@RunWith(MockitoJUnitRunner.Silent.class)
public class IngredientsControllerTDD {
	
	@Mock
	IIngredientsService ingredientsService;
	
	@Test
	public void ShowAllIngredients() {
		
		List<Ingredients> expected = this.getListOfIngredients();
		
		IngredientsController sut = new IngredientsController(ingredientsService);
		
		Mockito.when(ingredientsService.getAllIngredients())
        .thenReturn(expected);
		
		List<Ingredients> result = sut.getAllIngredients();
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
