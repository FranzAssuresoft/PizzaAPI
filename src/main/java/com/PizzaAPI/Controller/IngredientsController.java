package com.PizzaAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaAPI.Service.IIngredientsService;
import com.PizzaAPI.dtos.Ingredients;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
	
	@Autowired 
	private IIngredientsService ingredientsService;
	
	public IngredientsController(IIngredientsService ingredientsService)
	{
		this.ingredientsService = ingredientsService;
	}
	
	@GetMapping()
	public List<Ingredients> getAllIngredients(){
		return ingredientsService.getAllIngredients();
		
	}
	
	

}
