package buisness.Impl;


import Skect.buisness.Impl.WorkServiceUseCaseImpl.UpdateWorkServiceUseCaseImpl;
import Skect.domain.WorkService.UpdateServiceRequest;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UpdateServiceUseCaseRequestTest {

    @Mock
    private ServiceRepository mockServiceRepository;

    @Test
    void updateService() {
        UpdateWorkServiceUseCaseImpl updateServiceUseCase = new UpdateWorkServiceUseCaseImpl(mockServiceRepository);


        UpdateServiceRequest request = UpdateServiceRequest.builder().id(1).name("name1").description("description1").category(new ArrayList<>()).build();
        WorkServiceEntity Service = WorkServiceEntity.builder().id(1).name("name1").description("description1").categories(new ArrayList<>()).build();




        updateServiceUseCase.UpdateService(request);

        verify(mockServiceRepository).save(Service);


    }
}
