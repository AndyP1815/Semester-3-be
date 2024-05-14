package Skect.repositories;


import Skect.repositories.Entity.WorkServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ServiceRepository extends JpaRepository<WorkServiceEntity,Long> {
    ////List<WorkServiceEntity> GetAllServices();
   // void SaveService(WorkServiceEntity service);
   // void DeleteService(Long id);
   // void UpdateService(WorkServiceEntity service);
   // WorkServiceEntity GetServiceById(long id);
}
