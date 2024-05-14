package Skect.buisness.Impl.CatogryUseCaseImpl;

import Skect.buisness.CatogoryUseCases.CreateCategoryUseCase;
import Skect.domain.CatogoryPackage.CreateCategoryRequest;
import Skect.repositories.CategoryRepository;
import Skect.repositories.Entity.CategoryEntity;
import Skect.repositories.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;
    @Override
    public void CreateCategory(CreateCategoryRequest request) {
       CategoryEntity category = CategoryEntity.builder()
               .description(request.getDescription())
               .name(request.getName())
               .imageUrl(request.getImageUrl()).build();
        categoryRepository.save(category);
    }
}
