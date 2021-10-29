package User;

import com.PizzaAPI.dtos.User;
import com.PizzaAPI.repositories.IUserRepository;
import com.PizzaAPI.repositories.UserRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UsersTests {
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
        assertEquals(0, result.size());
    }
}
