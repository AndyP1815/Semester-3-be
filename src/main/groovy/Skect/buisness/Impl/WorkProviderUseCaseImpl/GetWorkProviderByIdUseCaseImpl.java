package Skect.buisness.Impl.WorkProviderUseCaseImpl;

import Skect.buisness.Impl.JobUseCaseImpl.JobConverter;
import Skect.buisness.Impl.OrderUseCaseImpl.OrderConverter;
import Skect.buisness.Impl.WorkServiceUseCaseImpl.WorkServiceConverter;
import Skect.buisness.ProviderUseCases.GetProviderByIdUseCase;
import Skect.domain.WorkProvider.GetProviderByIdResponse;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetWorkProviderByIdUseCaseImpl implements GetProviderByIdUseCase {
    private final ProviderRepository providerRepository;

    @Override
    public GetProviderByIdResponse GetProviderById(long id) {

        Optional<WorkProviderEntity> p = providerRepository.findById(id);
        if(p.isPresent()) {
            return GetProviderByIdResponse.builder().service(WorkServiceConverter.Convert(p.get().getService()))
                    .description(p.get().getDescription())
                    .username(p.get().getUsername())
                    .description(p.get().getDescription())
                    .workOrders(p.get().getWorkOrders().stream().map(OrderConverter::Convert).toList())
                    .offerJobs(p.get().getOfferJobs().stream().map(JobConverter::Convert).toList())
                    .servicesOrdered(p.get().getServicesOrdered().stream().map(OrderConverter::Convert).toList())
                    .id(p.get().getId()).build();
        }
        else
        {
            throw new IllegalArgumentException("User with ID " + id + " not found");
        }

    }
}
