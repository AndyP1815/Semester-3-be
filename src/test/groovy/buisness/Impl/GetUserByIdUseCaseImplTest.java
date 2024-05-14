package buisness.Impl;

import Skect.buisness.Impl.UserUseCaseImpl.GetUserByIdUseCaseImpl;
import Skect.domain.UserPackage.GetUserByIdResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetUserByIdUseCaseImplTest {

    @Mock
    private UserRepository mockUserRepository;
    @Test
    void getUserById() {
        UserEntity User1 = UserEntity.builder().id(1).password("Password1").username("User1").chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();

        when(mockUserRepository.findById((long)1)).thenReturn(Optional.ofNullable(User1));

        GetUserByIdUseCaseImpl getUserByIdUseCase = new GetUserByIdUseCaseImpl(mockUserRepository);
        GetUserByIdResponse result = getUserByIdUseCase.GetUserById(1);

        GetUserByIdResponse expectedResult = GetUserByIdResponse.builder().id(1).password("Password1").username("User1").chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();

        assertEquals(result,expectedResult);
        verify(mockUserRepository).findById((long)1);


    }
}