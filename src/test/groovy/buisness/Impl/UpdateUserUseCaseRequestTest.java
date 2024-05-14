package buisness.Impl;


import Skect.buisness.Impl.UserUseCaseImpl.UpdateUserUseCaseImpl;
import Skect.domain.UserPackage.UpdateUserRequest;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseRequestTest {

    @Mock
    private UserRepository mockUserRepository;

    @Test
    void updateUser() {
        UpdateUserUseCaseImpl updateUserUseCase = new UpdateUserUseCaseImpl(mockUserRepository);


        UpdateUserRequest request = UpdateUserRequest.builder().id((long)1).username("test").password("test").notifications(new ArrayList<>()).chats(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();
        UserEntity user = UserEntity.builder().id((long)1).username("test").password("test").notifications(new ArrayList<>()).chats(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();

        updateUserUseCase.UpdateUser(request);

        verify(mockUserRepository).save(user);
    }
}
