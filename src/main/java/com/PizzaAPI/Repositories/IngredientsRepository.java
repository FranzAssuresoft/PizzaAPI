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
import com.google.firebase.database.FirebaseDatabase;

@Repository
public class IngredientsRepository implements IIngredientsRepository {
	
	
	private Firestore firestore;

	@Override
	public ArrayList<Ingredients> getAllIngredients() {
		ArrayList<Ingredients> ingredients = new ArrayList<>();	      
		firestore = FirestoreClient.getFirestore();
		CollectionReference documentReference = firestore.collection("Ingredient");
		ApiFuture<QuerySnapshot> future =
		firestore.collection("Ingredients").get();
		List<QueryDocumentSnapshot> documents = null;
		try {
			documents = future.get().getDocuments();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for (DocumentSnapshot document : documents) {
			Ingredients ingredient = new Ingredients(document.getId(),document.getData().values().toArray()[1].toString(),Double.parseDouble(document.getData().values().toArray()[0].toString()));
			ingredients.add(ingredient);
            document.getData().values();
            System.out.println(document.getData().values().toArray()[1]);
		    document.getId();
		}
		
		   return ingredients; 
	 	
		
		  }

	


}
