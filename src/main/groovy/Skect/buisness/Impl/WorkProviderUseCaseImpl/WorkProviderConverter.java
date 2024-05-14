package Skect.buisness.Impl.WorkProviderUseCaseImpl;

import Skect.buisness.Impl.JobUseCaseImpl.JobConverter;
import Skect.buisness.Impl.OrderUseCaseImpl.OrderConverter;
import Skect.buisness.Impl.WorkServiceUseCaseImpl.WorkServiceConverter;
import Skect.domain.WorkProvider.WorkProvider;
import Skect.repositories.Entity.WorkProviderEntity;
import org.springframework.stereotype.Component;

@Component
final class WorkProviderConverter {
    private WorkProviderConverter(){

    }
    public static WorkProvider Convert(WorkProviderEntity entity){
        return WorkProvider.builder().id(entity.getId())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .service(WorkServiceConverter.Convert(entity.getService()))
                .offerJobs(entity.getOfferJobs().stream().map(JobConverter::Convert).toList())
                .workOrders(entity.getWorkOrders().stream().map(OrderConverter::Convert).toList())
                .servicesOrdered(entity.getServicesOrdered().stream().map(OrderConverter::Convert).toList())
                .description(entity.getDescription()).build();

    }
}
