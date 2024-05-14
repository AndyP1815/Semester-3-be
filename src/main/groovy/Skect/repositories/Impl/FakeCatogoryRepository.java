package Skect.repositories.Impl;

import Skect.repositories.Entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeCatogoryRepository //implements CategoryRepository
 {

    private List<CategoryEntity>catogories;
    public FakeCatogoryRepository()
    {
        catogories = new ArrayList<>();
        catogories.add(CategoryEntity.builder().name("Art").description("Art Description").id(1).imageUrl("/src/assets//Art.jpg").build());
        catogories.add(CategoryEntity.builder().name("Photography").description("Photography Description").id(2).imageUrl("/src/assets//Photography.jpg").build());
        catogories.add(CategoryEntity.builder().name("Plumbing").description("Plumbing Description").id(3).imageUrl("/src/assets//Pluming.jpg").build());
        catogories.add(CategoryEntity.builder().name("Film").description("Film Description").id(4).imageUrl("/src/assets//Film.jpg").build());
        catogories.add(CategoryEntity.builder().name("Design").description("Design Description").id(5).imageUrl("/src/assets//Design.jpg").build());
    }


    //@Override
    public List<CategoryEntity> GetAllCatogories() {
        return catogories;
    }

    //@Override
    public void SaveCatogory(CategoryEntity Catogory) {

    }

    ////@Override
    public void DeleteCatogory(Long id) {

    }

    //@Override
    public void UpdateCatogory(CategoryEntity Catogory) {

    }

   // @Override
    public CategoryEntity GetCatogoryById(long id) {
        return null;
    }
}
