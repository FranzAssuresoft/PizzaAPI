package com.PizzaAPI.repositories;

import com.PizzaAPI.dtos.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Console;
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
    public Boolean deleteUser(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User updateUser(User User) {
        // TODO Auto-generated method stub
        return null;
    }
}
