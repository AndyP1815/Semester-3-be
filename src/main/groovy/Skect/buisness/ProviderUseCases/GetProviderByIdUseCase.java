package Skect.buisness.ProviderUseCases;

import Skect.domain.WorkProvider.GetProviderByIdResponse;

public interface GetProviderByIdUseCase {
    GetProviderByIdResponse GetProviderById(long id);
}
