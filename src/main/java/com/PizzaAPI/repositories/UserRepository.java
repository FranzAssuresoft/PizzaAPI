package com.PizzaAPI.repositories;

import com.PizzaAPI.dtos.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.io.Console;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 3e286069ba42b4e4dee89f03a2cc15542276986b
import java.util.concurrent.ExecutionException;

@Repository
public class UserRepository implements IUserRepository {

    private final Firestore dbFirestore;

    @Autowired
    public UserRepository(Firestore dbFirestore) {
        this.dbFirestore = dbFirestore;
    }

    @Override
    public User createUser(User user) throws InterruptedException, ExecutionException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("User").document().set(user);
//        System.out.println(collectionsApiFuture.get().getUpdateTime());
        return user;
    }

    @Override
    public User getUser(String id) throws InterruptedException, ExecutionException {
        DocumentReference documentReference = dbFirestore.collection("User").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            User user = document.toObject(User.class);
            return user;
        }
        return null;
    }

    @Override
<<<<<<< HEAD
    public Boolean deleteUser(String id) {
=======
    public List<User> getAllUser() throws InterruptedException, ExecutionException {
        List<User> users = new ArrayList<User>();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("User").get();
        List<QueryDocumentSnapshot> documents = null;
        try{
            documents = future.get().getDocuments();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            for (DocumentSnapshot document : documents) {
                User user = new User();
                user = document.toObject(User.class);
                users.add(user);
            }	
        
        return users; 
    }

    @Override
    public String deleteUser(String id) {
>>>>>>> 3e286069ba42b4e4dee89f03a2cc15542276986b
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User updateUser(User User) {
        // TODO Auto-generated method stub
        return null;
    }

}
