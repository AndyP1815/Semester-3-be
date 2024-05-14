package Skect.buisness.Impl.WorkServiceUseCaseImpl;

import Skect.buisness.WorkServiceUSeCases.GetServiceByIdUseCase;
import Skect.domain.WorkService.GetServiceByIdResponse;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Skect.buisness.Impl.CatogryUseCaseImpl.CategoryConverter;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetWorkServiceByIdUseCaseImpl implements GetServiceByIdUseCase {
    private final ServiceRepository serviceRepository;
    @Override
    public GetServiceByIdResponse GetServiceById(Long id) {
        Optional<WorkServiceEntity> service = serviceRepository.findById(id);

        if(service.isPresent()){
        return GetServiceByIdResponse.builder()
                .id(service.get().getId()).description(service.get().getDescription())
                .name(service.get().getName())
                .images(service.get().getImages())
                .category(service.get().getCategories().stream().map(CategoryConverter::Convert).toList()).build();
    }
        else
        {
            throw new IllegalArgumentException("User with ID " + id + " not found");
        }
    }
}
