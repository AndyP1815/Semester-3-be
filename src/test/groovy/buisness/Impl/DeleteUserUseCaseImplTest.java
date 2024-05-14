package buisness.Impl;

import Skect.buisness.Impl.UserUseCaseImpl.DeleteUserUseCaseImpl;
import Skect.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
class DeleteUserUseCaseImplTest {

    @Mock
    private UserRepository mockUserRepository;

    @Test
    void deleteUser_Success() {
        long deleteId = 1;

        DeleteUserUseCaseImpl deleteUserUseCase = new DeleteUserUseCaseImpl(mockUserRepository);

        deleteUserUseCase.deleteUser(deleteId);


        //verify(mockUserRepository).DeleteUser(deleteId);
    }
}