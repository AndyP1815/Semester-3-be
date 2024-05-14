package buisness.Impl;

import Skect.buisness.Impl.WorkServiceUseCaseImpl.GetWorkServiceByIdUseCaseImpl;
import Skect.domain.WorkService.GetServiceByIdResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetServiceByIdUseCaseImplTest {

    @Mock
    private ServiceRepository mockServiceRepository;
    @Test
    void getServiceById() {
        WorkServiceEntity Service1 = WorkServiceEntity.builder().id(1).name("name1").description("description1").categories(new ArrayList<>()).build();

        when(mockServiceRepository.findById((long)1)).thenReturn(Optional.ofNullable(Service1));

        GetWorkServiceByIdUseCaseImpl getServiceByIdUseCase = new GetWorkServiceByIdUseCaseImpl(mockServiceRepository);
        GetServiceByIdResponse result = getServiceByIdUseCase.GetServiceById((long)1);

        GetServiceByIdResponse expectedResult = GetServiceByIdResponse.builder().id(1).name("name1").description("description1").category(new ArrayList<>()).build();

        assertEquals(result,expectedResult);
        verify(mockServiceRepository).findById((long)1);


    }
}
