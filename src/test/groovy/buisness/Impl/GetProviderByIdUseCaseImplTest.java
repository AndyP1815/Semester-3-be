package buisness.Impl;

import Skect.buisness.Impl.WorkProviderUseCaseImpl.GetWorkProviderByIdUseCaseImpl;
import Skect.domain.WorkProvider.GetProviderByIdResponse;
import Skect.domain.WorkService.WorkService;
import Skect.repositories.Entity.WorkServiceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.ProviderRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetProviderByIdUseCaseImplTest {

    @Mock
    private ProviderRepository mockProviderRepository;
    @Test
    void getProviderById() {
        WorkProviderEntity Provider1 = WorkProviderEntity.builder().username("providername").password("Password").description("description").service(WorkServiceEntity.builder().name("name").id(1).description("description").build()).workOrders(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();
        when(mockProviderRepository.findById((long)1)).thenReturn(Optional.ofNullable(Provider1));

        GetWorkProviderByIdUseCaseImpl getProviderByIdUseCase = new GetWorkProviderByIdUseCaseImpl(mockProviderRepository);
        GetProviderByIdResponse result = getProviderByIdUseCase.GetProviderById(1);

        GetProviderByIdResponse expectedResult = GetProviderByIdResponse.builder().username("providername").password("Password").description("description").service(WorkService.builder().name("name").id(1).description("description").build()).workOrders(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();

        assertEquals(result,expectedResult);
        verify(mockProviderRepository).findById((long)1);


    }
}