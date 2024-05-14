package buisness.Impl;

import Skect.buisness.Impl.WorkServiceUseCaseImpl.DeleteWorkServiceUseCaseImpl;
import Skect.repositories.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class DeleteServiceUseCaseImplTest {
    
    @Mock
    private ServiceRepository mockServiceRepository;

    @Test
    void deleteSercvice() {
        long deleteId = 1;

        DeleteWorkServiceUseCaseImpl deleteServiceUseCase = new DeleteWorkServiceUseCaseImpl(mockServiceRepository);

        deleteServiceUseCase.DeleteSercvice(deleteId);




    }
}