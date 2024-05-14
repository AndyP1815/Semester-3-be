package Skect.buisness.ProviderUseCases;

import Skect.domain.WorkProvider.UpdateProviderRequest;
import Skect.repositories.Entity.WorkProviderEntity;

public interface UpdateProviderUseCase {
    void UpdateProvider(UpdateProviderRequest request);
}
