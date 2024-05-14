package Skect.buisness.Impl.WorkProviderUseCaseImpl;

import Skect.buisness.Impl.WorkServiceUseCaseImpl.WorkServiceConverter;
import Skect.buisness.ProviderUseCases.CreateProviderUseCase;
import Skect.domain.WorkProvider.CreateProviderRequest;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.ProviderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CreateWorkProviderUseCaseImpl implements CreateProviderUseCase
{

    private final ProviderRepository providerRepository;

    @Transactional
    @Override
    public void CreateProvider(CreateProviderRequest request) {
        WorkProviderEntity provider = WorkProviderEntity.builder().service(WorkServiceConverter.Convert2(request.getService()))
                .description(request.getDescription())
                .password(request.getPassword())
                .username(request.getUsername())
                .servicesOrdered(new ArrayList<>())
                .workOrders(new ArrayList<>())
                .offerJobs(new ArrayList<>()).build();

        providerRepository.save(provider);
    }
}
