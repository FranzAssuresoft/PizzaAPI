package com.PizzaAPI.Repositories;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.PizzaAPI.dtos.Ingredients;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;

@RunWith(MockitoJUnitRunner.Silent.class)
public class IngredientRepositoryTest {
	
	@Mock
	private QuerySnapshot QS;
	
	@Mock
	private List<QueryDocumentSnapshot> LQS;
	
    @Mock 
	private CollectionReference fakeCollectionIngredients;
    @Mock
    private ApiFuture<QuerySnapshot> future;
	
	@Mock
	private Firestore IngredientsDB;
	
	@Test
	public void getAllIngredients() throws Exception{
	   Firestore mockFirestore = Mockito.mock(Firestore.class);        
	   Mockito.when(QS.getDocuments()).thenReturn(LQS);
	   Mockito.when(future.get()).thenReturn(QS);	
	   Mockito.when(fakeCollectionIngredients.get()).thenReturn(future);
	   Mockito.when(mockFirestore.collection("Ingredients")).thenReturn(fakeCollectionIngredients);
	
	    
	   IIngredientsRepository sut = new IngredientsRepository(mockFirestore);
	   List<Ingredients> result = sut.getAllIngredients();
	   assertEquals(0, result.size());
	}

}