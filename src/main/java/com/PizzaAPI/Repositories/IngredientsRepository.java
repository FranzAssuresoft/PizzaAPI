package com.PizzaAPI.Repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


import org.springframework.stereotype.Repository;
import com.PizzaAPI.dtos.Ingredients;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Repository
public class IngredientsRepository implements IIngredientsRepository {
	
	
	private Firestore firestore;
	
	public IngredientsRepository (Firestore firestore) {
		this.firestore = firestore;
	}
	
	public IngredientsRepository() {
		
	}

	@Override
	public List<Ingredients> getAllIngredients() {
	    List<Ingredients> ingredients= new ArrayList<Ingredients>();
		if(this.firestore == null) {
			this.firestore = FirestoreClient.getFirestore();
		}
		CollectionReference ingredientReference = firestore.collection("Ingredients");
		ApiFuture<QuerySnapshot> future = ingredientReference.get();
		List<QueryDocumentSnapshot> documents = null;
		try {
			documents = future.get().getDocuments();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	    if(documents.size()>0) {
		for (DocumentSnapshot document : documents) {
			Ingredients ingredient = new Ingredients();
			ingredient = document.toObject(Ingredients.class);
			ingredients.add(ingredient);
		 }
		
	    }
		   return ingredients; 
	 	
		
		  }

	


}