package Skect.buisness.CatogoryUseCases;

import Skect.domain.CatogoryPackage.CreateCategoryRequest;
import Skect.domain.WorkProvider.CreateProviderRequest;

public interface CreateCategoryUseCase {
    void CreateCategory(CreateCategoryRequest request);
}
