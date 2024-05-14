package Skect.buisness.Impl.CatogryUseCaseImpl;

import Skect.buisness.CatogoryUseCases.GetAllCatogoriesUseCase;
import Skect.domain.CatogoryPackage.Category;
import Skect.domain.CatogoryPackage.GetAllCatogoriesResponse;

import Skect.repositories.CategoryRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllCatogoriesUseCaseImpl implements GetAllCatogoriesUseCase {
    private final CategoryRepository catogoryRepository;


    @Override
    public GetAllCatogoriesResponse GetAllCatogories() {
        List<Category> categories = catogoryRepository.findAll().stream().map(CategoryConverter::Convert).toList();
        return GetAllCatogoriesResponse.builder().catogories(categories).build();
    }
}
