package Skect.buisness.Impl.WorkProviderUseCaseImpl;


import Skect.buisness.ProviderUseCases.GetAllProvidersUseCase;
import Skect.domain.WorkProvider.GetAllProvidersResponse;
import Skect.domain.WorkProvider.WorkProvider;
import Skect.repositories.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllWorkProvidersUceCaseImpl implements GetAllProvidersUseCase {
    private final ProviderRepository providerRepository;

    @Override
    public GetAllProvidersResponse GetAllProviders() {
        List<WorkProvider> providers = providerRepository.findAll().stream().map(WorkProviderConverter::Convert).toList();
        return GetAllProvidersResponse.builder().providers(providers).build();
    }
}
