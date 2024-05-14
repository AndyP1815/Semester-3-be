package buisness.Impl;

import Skect.buisness.Impl.WorkProviderUseCaseImpl.GetAllWorkProvidersUceCaseImpl;
import Skect.domain.WorkProvider.GetAllProvidersResponse;
import Skect.domain.WorkProvider.WorkProvider;
import Skect.domain.WorkService.WorkService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ProviderRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class GetAllProvidersUceCaseImplTest {

    @Mock
    private ProviderRepository mockProviderrepository;

    @Test
    void getAllProviders() {
        WorkProviderEntity provider1 = WorkProviderEntity.builder().description("description1").service(WorkServiceEntity.builder().name("User1").description("Description1").id(1).build()).password("password1").username("username1").id(1).workOrders(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();
        WorkProviderEntity provider2 = WorkProviderEntity.builder().description("description2").service(WorkServiceEntity.builder().name("User2").description("Description2").id(2).build()).password("password2").username("username2").id(2).workOrders(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();

        when(mockProviderrepository.findAll()).thenReturn(List.of(provider1,provider2));

        GetAllWorkProvidersUceCaseImpl getProviderUseCase = new GetAllWorkProvidersUceCaseImpl(mockProviderrepository);

        GetAllProvidersResponse result = getProviderUseCase.GetAllProviders();

        WorkProvider provider_1 = WorkProvider.builder().description("description1").service(WorkService.builder().name("User1").description("Description1").id(1).build()).password("password1").username("username1").id(1).workOrders(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();
        WorkProvider provider_2 = WorkProvider.builder().description("description2").service(WorkService.builder().name("User2").description("Description2").id(2).build()).password("password2").username("username2").id(2).workOrders(new ArrayList<>()).chats(new ArrayList<>()).notifications(new ArrayList<>()).offerJobs(new ArrayList<>()).servicesOrdered(new ArrayList<>()).build();

        GetAllProvidersResponse expectedResult = GetAllProvidersResponse.builder().providers(List.of(provider_1,provider_2)).build();

        assertEquals(result,expectedResult);
        verify(mockProviderrepository).findAll();
    }
}