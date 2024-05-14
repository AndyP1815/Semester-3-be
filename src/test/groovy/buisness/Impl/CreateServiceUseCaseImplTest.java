package buisness.Impl;

import Skect.buisness.Impl.WorkServiceUseCaseImpl.CreateWorkServiceUseCaseImpl;
import Skect.domain.WorkService.CreateServiceRequest;
import Skect.repositories.Entity.CategoryEntity;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CreateServiceUseCaseImplTest {

    @Mock
    private ServiceRepository mockRepository;
    @Test
    void createService() {
        CreateServiceRequest request = CreateServiceRequest.builder().name("name").description("description").category(new ArrayList<>()).build();
        CreateWorkServiceUseCaseImpl createServiceUseCase = new CreateWorkServiceUseCaseImpl(mockRepository);


        WorkServiceEntity createdService = WorkServiceEntity.builder().name("name").description("description").categories(new ArrayList<>()).id(4).build();


        when(mockRepository.findById((long)4)).thenReturn(Optional.ofNullable(createdService));


        createServiceUseCase.CreateService(request);

        Optional<WorkServiceEntity> result = mockRepository.findById((long)4);

        assertEquals(createdService, result.get());
    }
}