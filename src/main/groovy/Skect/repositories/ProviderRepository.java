package Skect.repositories;

import Skect.repositories.Entity.WorkProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProviderRepository extends JpaRepository<WorkProviderEntity,Long> {
 //   List<WorkProviderEntity> GetAllProviders();
  //  void SaveProvider(WorkProviderEntity provider);
    //void DeleteProvider(Long id);

   // void UpdateProvider(WorkProviderEntity provider);
    //WorkProviderEntity GetProviderById(long id);
}
