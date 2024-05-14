package buisness.Impl;

import Skect.buisness.Impl.WorkProviderUseCaseImpl.DeleteWorkProviderUseCaseImpl;

import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteProviderUseCaseImplTest {

    @Mock
    private ProviderRepository mockProviderRepository;

    @Test
    void deleteProvider_Success() {
        // Arrange
        long providerId = 4L;

        // Act
        DeleteWorkProviderUseCaseImpl deleteProviderUseCase = new DeleteWorkProviderUseCaseImpl(mockProviderRepository);
        deleteProviderUseCase.DeleteProvider(providerId);


    }
}
