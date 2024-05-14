package buisness.Impl;


import Skect.buisness.Impl.WorkProviderUseCaseImpl.UpdateWorkProviderUseCaseImpl;
import Skect.domain.WorkProvider.UpdateProviderRequest;
import Skect.domain.WorkService.WorkService;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UpdateProviderUseCaseRequestTest {

    @Mock
    private ProviderRepository mockProviderRepository;

    @Test
    void updateProvider() {
        UpdateWorkProviderUseCaseImpl updateProviderUseCase = new UpdateWorkProviderUseCaseImpl(mockProviderRepository);

        WorkProviderEntity originalProvider = WorkProviderEntity.builder()
                .id(1)
                .username("originalUsername")
                .password("originalPassword")
                .description("originalDescription")
                .service(WorkServiceEntity.builder().name("originalService").id(1).description("originalDescription").build())
                .workOrders(new ArrayList<>())
                .chats(new ArrayList<>())
                .notifications(new ArrayList<>())
                .offerJobs(new ArrayList<>())
                .servicesOrdered(new ArrayList<>())
                .build();

        // Update request
        UpdateProviderRequest request = UpdateProviderRequest.builder()
                .id((long) 1)
                .username("updatedUsername")
                .password("updatedPassword")
                .description("updatedDescription")
                .service(WorkService.builder().name("updatedService").id(2).description("updatedDescription").build())
                .workOrders(new ArrayList<>())
                .chats(new ArrayList<>())
                .notifications(new ArrayList<>())
                .offerJobs(new ArrayList<>())
                .servicesOrdered(new ArrayList<>())
                .build();

        // Expected updated entity
        WorkProviderEntity expectedUpdatedProvider = WorkProviderEntity.builder()
                .id(1)
                .username("updatedUsername")
                .password("updatedPassword")
                .description("updatedDescription")
                .service(WorkServiceEntity.builder().name("updatedService").id(2).description("updatedDescription").build())
                .workOrders(new ArrayList<>())
                .chats(new ArrayList<>())
                .notifications(new ArrayList<>())
                .offerJobs(new ArrayList<>())
                .servicesOrdered(new ArrayList<>())
                .build();




    }
}
