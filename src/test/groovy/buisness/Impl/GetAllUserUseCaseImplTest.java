package buisness.Impl;

import Skect.buisness.Impl.UserUseCaseImpl.GetAllUserUseCaseImpl;
import Skect.domain.UserPackage.GetAllUserResponse;
import Skect.domain.UserPackage.User;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = GetAllUserUseCaseImplTest.class)
@ExtendWith(MockitoExtension.class)
class GetAllUserUseCaseImplTest {

    @Mock
    private  UserRepository mockUserRepository;

    @Test
    void getUsers() {

        UserEntity User1 = UserEntity.builder().id(1).password("Password1").username("User1").servicesOrdered(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).build();
        UserEntity User2 = UserEntity.builder().id(2).password("Password2").username("User2").servicesOrdered(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).build();
        when(mockUserRepository.findAll()).thenReturn(List.of(User1,User2));

        GetAllUserUseCaseImpl getUserUseCase = new GetAllUserUseCaseImpl(mockUserRepository);
        GetAllUserResponse result = getUserUseCase.GetUsers();

        User User_1 = User.builder().id(1).password("Password1").username("User1").servicesOrdered(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).build();
        User User_2 = User.builder().id(2).password("Password2").username("User2").servicesOrdered(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).build();

        GetAllUserResponse expectedResult = GetAllUserResponse.builder().users(List.of(User_1,User_2)).build();

        assertEquals(result,expectedResult);
        verify(mockUserRepository).findAll();

    }
}