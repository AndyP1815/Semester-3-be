package Skect.buisness.Impl.WorkServiceUseCaseImpl;

import Skect.buisness.WorkServiceUSeCases.UpdateServiceUseCase;
import Skect.domain.WorkService.UpdateServiceRequest;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Skect.buisness.Impl.CatogryUseCaseImpl.CategoryConverter;

@Service
@AllArgsConstructor
public class UpdateWorkServiceUseCaseImpl implements UpdateServiceUseCase {
    private final ServiceRepository serviceRepository;
    @Override
    public void UpdateService(UpdateServiceRequest request) {
        WorkServiceEntity service = WorkServiceEntity.builder()
                .id(request.getId())
                .description(request.getDescription())
                .name(request.getName())
                .images(request.getImages())
                .categories(request.getCategory().stream().map(CategoryConverter::ConvertToEntity ).toList())
                .build();
        serviceRepository.save(service);

    }


}
