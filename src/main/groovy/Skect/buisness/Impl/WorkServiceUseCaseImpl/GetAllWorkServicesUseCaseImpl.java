package Skect.buisness.Impl.WorkServiceUseCaseImpl;

import Skect.buisness.WorkServiceUSeCases.GetAllServicesUseCase;
import Skect.domain.WorkService.GetAllServiceResponse;
import Skect.domain.WorkService.WorkService;
import Skect.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GetAllWorkServicesUseCaseImpl implements GetAllServicesUseCase {
    private final ServiceRepository serviceRepository;


    @Override
    public GetAllServiceResponse GetServices() {
     List<WorkService>Services = serviceRepository.findAll().
             stream().
             map(WorkServiceConverter::Convert).toList();
     return GetAllServiceResponse.builder().services(Services).build();
    }
}
