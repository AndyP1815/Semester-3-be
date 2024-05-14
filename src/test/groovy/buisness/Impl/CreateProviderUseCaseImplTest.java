package buisness.Impl;
import Skect.buisness.Impl.WorkProviderUseCaseImpl.CreateWorkProviderUseCaseImpl;
import Skect.domain.WorkProvider.CreateProviderRequest;
import Skect.domain.WorkService.WorkService;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CreateProviderUseCaseImplTest {

    @Mock
    private ProviderRepository mockProviderRepository;
    @Test
    void createProvider() {
        CreateProviderRequest request = CreateProviderRequest.builder().username("providername").password("Password").description("description").service(WorkService.builder().name("name").id(1).description("description").build()).build();
        CreateWorkProviderUseCaseImpl createproviderUseCase = new CreateWorkProviderUseCaseImpl(mockProviderRepository);


        WorkProviderEntity createdprovider = WorkProviderEntity.builder().username("providername").password("Password").id(4).description("description").service(WorkServiceEntity.builder().name("name").id(1).description("description").build()).build();


        when(mockProviderRepository.findById((long)4)).thenReturn(Optional.ofNullable(createdprovider));
        createproviderUseCase.CreateProvider(request);

        Optional<WorkProviderEntity> result = mockProviderRepository.findById((long)4);

        assertEquals(createdprovider, result.get());
    }
}