package Skect.buisness.Impl.WorkProviderUseCaseImpl;

import Skect.buisness.ProviderUseCases.DeleteProviderUseCase;
import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteWorkProviderUseCaseImpl implements DeleteProviderUseCase {
    private final ProviderRepository providerRepository;

    @Override
    public void DeleteProvider(long id) {
        Optional<WorkProviderEntity> workProviderEntity = providerRepository.findById(id);
        workProviderEntity.ifPresent(providerRepository::delete);

    }
}
