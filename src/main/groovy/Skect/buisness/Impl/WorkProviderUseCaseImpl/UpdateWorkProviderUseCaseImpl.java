package Skect.buisness.Impl.WorkProviderUseCaseImpl;

import Skect.buisness.Impl.JobUseCaseImpl.JobConverter;
import Skect.buisness.Impl.OrderUseCaseImpl.OrderConverter;
import Skect.buisness.Impl.WorkServiceUseCaseImpl.WorkServiceConverter;
import Skect.buisness.ProviderUseCases.UpdateProviderUseCase;
import Skect.domain.WorkProvider.UpdateProviderRequest;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateWorkProviderUseCaseImpl implements UpdateProviderUseCase {
    private final ProviderRepository providerRepository;

    @Override
    public void UpdateProvider(UpdateProviderRequest request) {
        WorkProviderEntity provider = WorkProviderEntity.builder().service(WorkServiceConverter.Convert2(request.getService()))
                .description(request.getDescription())
                .id(request.getId())
                .password(request.getPassword())
                .offerJobs(request.getOfferJobs().stream().map(JobConverter::ConvertToEntity).toList())
                .workOrders(request.getWorkOrders().stream().map(OrderConverter::ConvertToEntity).toList())
                .servicesOrdered(request.getServicesOrdered().stream().map(OrderConverter::ConvertToEntity).toList())
                .username(request.getUsername()).build();
        providerRepository.save(provider);

    }
}
