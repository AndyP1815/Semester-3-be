package Skect.repositories.Impl;

import Skect.repositories.Entity.WorkProviderEntity;
import Skect.repositories.Entity.WorkServiceEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class FakeProviderRepository //implements ProviderRepository
{
    private List<WorkProviderEntity> savedProviders;
    private static long NEXT_ID = 4;
    public FakeProviderRepository(){
        savedProviders = new ArrayList<>();
        savedProviders.add(WorkProviderEntity.builder().description("description1").service(WorkServiceEntity.builder().name("User1").description("Description1").id(1).build()).password("password1").username("username1").id(1).build());
        savedProviders.add(WorkProviderEntity.builder().description("description2").service(WorkServiceEntity.builder().name("User2").description("Description2").id(2).build()).password("password2").username("username2").id(2).build());
        savedProviders.add(WorkProviderEntity.builder().description("description3").service(WorkServiceEntity.builder().name("User3").description("Description3").id(3).build()).password("password3").username("username3").id(3).build());

    }
   // @Override
    public List<WorkProviderEntity> GetAllProviders() {
        return savedProviders;
    }

    //@Override
    public void SaveProvider(WorkProviderEntity provider) {
        provider.setId(NEXT_ID);
        NEXT_ID++;
        savedProviders.add(provider);

    }

   // @Override
    public void DeleteProvider(Long id) {
        savedProviders.removeIf(provider -> provider.getId() == id);

    }

   // @Override
    public void UpdateProvider(WorkProviderEntity provider) {

        for (WorkProviderEntity p:savedProviders
             ) if(p.getId() == provider.getId()){
            p.setService(provider.getService());
            p.setDescription(provider.getDescription());
            p.setUsername(provider.getUsername());
            p.setPassword(provider.getPassword());

        }
    }

   // @Override
    public WorkProviderEntity GetProviderById(long id) {
        for (WorkProviderEntity p:savedProviders
             ) if(p.getId() == id){
            return p;

        }
        return null;
    }
}
