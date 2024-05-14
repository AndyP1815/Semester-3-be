package Skect.repositories.Impl;

import Skect.repositories.Entity.WorkServiceEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeServiceRepository// implements ServiceRepository
{
    private List<WorkServiceEntity> savedServices;
    private static long NEXT_ID = 4;
    public FakeServiceRepository(){
        savedServices = new ArrayList<>();
        savedServices.add(WorkServiceEntity.builder().name("User1").description("Description1").id(1).build());
        savedServices.add(WorkServiceEntity.builder().name("User2").description("Description2").id(2).build());
        savedServices.add(WorkServiceEntity.builder().name("User3").description("Description3").id(3).build());
    }

   // @Override
    public List<WorkServiceEntity> GetAllServices() {
        return savedServices;
    }

    //@Override
    public void SaveService(WorkServiceEntity service) {

        service.setId(NEXT_ID);
        savedServices.add(service);
        NEXT_ID++;
    }

    ///@Override
    public void DeleteService(Long id) {
        savedServices.removeIf(s -> s.getId() == id);

    }

    //@Override
    public void UpdateService(WorkServiceEntity service) {

        for (WorkServiceEntity s:savedServices
             ) if(s.getId() == service.getId()){
            s.setDescription(service.getDescription());
            s.setName(service.getName());

        }
    }

   // @Override
    public WorkServiceEntity GetServiceById(long id) {

        for (WorkServiceEntity s:savedServices
             ) if(s.getId() == id){
            return s;
        };
        return null;
    }
}
