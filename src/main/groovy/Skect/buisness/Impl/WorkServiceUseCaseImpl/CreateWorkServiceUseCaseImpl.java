package Skect.buisness.Impl.WorkServiceUseCaseImpl;

import Skect.buisness.Impl.CatogryUseCaseImpl.CategoryConverter;
import Skect.buisness.WorkServiceUSeCases.CreateServiceUseCase;
import Skect.domain.WorkService.CreateServiceRequest;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateWorkServiceUseCaseImpl implements CreateServiceUseCase {
    private final ServiceRepository serviceRepository;
    @Override
    public void CreateService(CreateServiceRequest request) {
        WorkServiceEntity service = WorkServiceEntity.builder()
                .name(request.getName()).
                description(request.getDescription())
                .images(request.getImages())
                .categories(request.getCategory().stream().map(CategoryConverter::ConvertToEntity).toList()).build();
        serviceRepository.save(service);
    }
}
