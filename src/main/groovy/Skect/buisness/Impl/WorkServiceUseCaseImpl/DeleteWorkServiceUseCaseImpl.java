package Skect.buisness.Impl.WorkServiceUseCaseImpl;

import Skect.buisness.WorkServiceUSeCases.DeleteServiceUseCase;
import Skect.repositories.Entity.WorkServiceEntity;
import Skect.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteWorkServiceUseCaseImpl implements DeleteServiceUseCase {
    private final ServiceRepository serviceRepository;

    @Override
    public void DeleteSercvice(long id) {
        Optional<WorkServiceEntity> workService = serviceRepository.findById(id);

        workService.ifPresent(serviceRepository::delete);


    }
}
