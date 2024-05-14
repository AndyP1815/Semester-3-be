package buisness.Impl;

import Skect.buisness.Impl.WorkServiceUseCaseImpl.GetAllWorkServicesUseCaseImpl;
import Skect.domain.WorkService.GetAllServiceResponse;
import Skect.domain.WorkService.WorkService;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = GetAllServicesUseCaseImplTest.class)
@ExtendWith(MockitoExtension.class)
class GetAllServicesUseCaseImplTest {

    @Mock
    private ServiceRepository mockServiceRepository;
    @Test
    void getServices() {
        WorkServiceEntity serviceEntity1 = WorkServiceEntity.builder().id(1).name("name1").description("description1").build();
        WorkServiceEntity serviceEntity2 = WorkServiceEntity.builder().id(2).name("name2").description("description2").build();

        when(mockServiceRepository.findAll()).thenReturn(List.of(serviceEntity1,serviceEntity2));

        GetAllWorkServicesUseCaseImpl getAllServicesUseCase = new GetAllWorkServicesUseCaseImpl(mockServiceRepository);

        GetAllServiceResponse result = getAllServicesUseCase.GetServices();

        WorkService service1 = WorkService.builder().id(1).name("name1").description("description1").build();
        WorkService service2 = WorkService.builder().id(2).name("name2").description("description2").build();

        GetAllServiceResponse expectedResult = GetAllServiceResponse.builder().services(List.of(service1,service2)).build();


        assertEquals(result,expectedResult);
        verify(mockServiceRepository).findAll();
    }
}