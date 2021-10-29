package com.PizzaAPI.Repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.PizzaAPI.dtos.Ingredients;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RunWith(MockitoJUnitRunner.Silent.class)
public class IngredientRepositoryTest {
	
	@Mock
	private QuerySnapshot fakeQuerySnapshot;
	
	@Mock
	private List<QueryDocumentSnapshot> fakeListQuerySnapshot;
	
    @Mock 
	private CollectionReference fakeCollectionIngredients;
    @Mock
    private ApiFuture<QuerySnapshot> fakeFuture;
	
	@Mock
	private Firestore IngredientsDB;
	
	@Test
	public void getAllIngredients() throws Exception{
	   Firestore mockFirestore = Mockito.mock(Firestore.class);        
	   Mockito.when(fakeQuerySnapshot.getDocuments()).thenReturn(fakeListQuerySnapshot);
	   Mockito.when(fakeFuture.get()).thenReturn(fakeQuerySnapshot);	
	   Mockito.when(fakeCollectionIngredients.get()).thenReturn(fakeFuture);
	   Mockito.when(mockFirestore.collection("Ingredients")).thenReturn(fakeCollectionIngredients);
	
	    
	   IIngredientsRepository sut = new IngredientsRepository(mockFirestore);
	   List<Ingredients> result = sut.getAllIngredients();
	   assertEquals(0, result.size());
	}

}