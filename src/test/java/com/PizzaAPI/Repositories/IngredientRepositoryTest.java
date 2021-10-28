package com.PizzaAPI.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;



import com.PizzaAPI.dtos.Ingredients;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;

public class IngredientRepositoryTest {
	
    @Mock 
	private CollectionReference fakeCollectionIngredients;
    
	 
	
	@Mock
	private Firestore IngredientsDB;
	
	@Test
	void getAllIngredients() throws Exception{
	   Firestore mockFirestore = Mockito.mock(Firestore.class);        
	   when(IngredientsDB.collection("MyDB").thenReturn(fakeCollectionIngredients));
	   
	   
	   IIngredientsRepository sut = new IngredientsRepository();
	   
			   
	
	}

}
