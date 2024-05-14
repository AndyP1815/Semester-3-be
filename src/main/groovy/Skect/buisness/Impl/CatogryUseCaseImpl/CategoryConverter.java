package Skect.buisness.Impl.CatogryUseCaseImpl;

import Skect.domain.CatogoryPackage.Category;
import Skect.repositories.Entity.CategoryEntity;

public class CategoryConverter {

    private CategoryConverter(){

    }
    public static Category Convert(CategoryEntity entity){
        return Category.builder().id(entity.getId())
                .name(entity.getName()).
                description(entity.getDescription()).imageUrl(entity.getImageUrl())
                .build();

    }
    public static CategoryEntity ConvertToEntity(Category catogory){
        return CategoryEntity.builder().id(catogory.getId())
                .name(catogory.getName()).
                description(catogory.getDescription()).imageUrl(catogory.getImageUrl())
                .build();

    }
    
}
