package com.PizzaAPI.Service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.PizzaAPI.Repositories.IIngredientsRepository;
import com.PizzaAPI.Repositories.IngredientsRepository;
import com.PizzaAPI.dtos.Ingredients;

@RunWith(MockitoJUnitRunner.Silent.class)
public class IngredientsServiceTest {
	

   	

    @Mock
	IIngredientsRepository ingredientsRepository;
    
    @Test
    public void getAllIngredients(){
    	
    	List<Ingredients> expected = new ArrayList<Ingredients>();
    	Ingredients ingredients = new Ingredients("1L", "Tomate", 2.5);
    	expected.add(ingredients);
    	ingredients = new Ingredients("2L", "Queso", 15);
    	expected.add(ingredients);
    	ingredients = new Ingredients("3L", "champiñones", 0.5);
    	expected.add(ingredients);
        
        Mockito.when(ingredientsRepository.getAllIngredients())
        .thenReturn(expected);
    	
        IIngredientsService sut = new IngredientsService(ingredientsRepository);
        List<Ingredients> result = sut.getAllIngredients();
    	
        assertEquals(result.size(),expected.size());
        
       
    }
	
}
