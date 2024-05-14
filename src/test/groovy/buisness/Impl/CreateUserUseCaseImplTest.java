package buisness.Impl;

import Skect.buisness.Impl.UserUseCaseImpl.CreateUserUseCaseImpl;
import Skect.domain.UserPackage.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CreateUserUseCaseImplTest.class)
@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseImplTest {

    @Mock
    private UserRepository mockRepository;

    @Test
    void createUser() {
        CreateUserRequest request = CreateUserRequest.builder().username("Username").password("Password").build();
        CreateUserUseCaseImpl createUserUseCase = new CreateUserUseCaseImpl(mockRepository);


        UserEntity createdUser = UserEntity.builder().username("Username").password("Password").id(4).build();


        when(mockRepository.findById((long)4)).thenReturn(Optional.ofNullable(createdUser));


        createUserUseCase.CreateUser(request);

        Optional<UserEntity> result = mockRepository.findById((long)4);

        assertEquals(createdUser, result.get());
    }
}