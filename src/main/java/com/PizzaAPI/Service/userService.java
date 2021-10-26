package com.PizzaAPI.Service;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.PizzaAPI.dtos.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
 
@Service
public class userService {

	public String createUser(User user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("User").document().set(user);
		return collectionsApiFuture.get().getUpdateTime().toString();
		
	}

	public User getUser(String id) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("User").document(id);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		User User;
		if(document.exists()) {
			User = document.toObject(User.class);
			return User;
		}

		return null;
	}

	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateUser(User User) {
		// TODO Auto-generated method stub
		return null;
	}



}
