package com.PizzaAPI.User;

import com.PizzaAPI.dtos.User;
import java.util.List;

import com.PizzaAPI.repositories.IUserRepository;
import com.PizzaAPI.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
class UsersTests {

    @Mock
    private QuerySnapshot fakeQuerySnapshot;

    @Mock
    private List<QueryDocumentSnapshot> fakeListQuerySnapshot;

    @Mock
    private CollectionReference fakeCollectionUser;

    @Mock
    private ApiFuture<QuerySnapshot> fakeFuture;

    @Mock
    private Firestore userDB;

    @Test
    public void getAllUsers() throws Exception{
        Firestore mockFirestore = Mockito.mock(Firestore.class);
        Mockito.when(fakeQuerySnapshot.getDocuments()).thenReturn(fakeListQuerySnapshot);
        Mockito.when(fakeFuture.get()).thenReturn(fakeQuerySnapshot);
        Mockito.when(fakeCollectionUser.get()).thenReturn(fakeFuture);
        Mockito.when(mockFirestore.collection("Users")).thenReturn(fakeCollectionUser);

        IUserRepository sut = new UserRepository(mockFirestore);
        List<User> result = sut.getAllUsers();
        Assertions.assertEquals(0, result.size());
    }
}
