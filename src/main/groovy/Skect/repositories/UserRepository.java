package Skect.repositories;

import Skect.repositories.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity,Long> {
   //List<UserEntity> GetAllUser();
   //void SaveUser(UserEntity user);
   //void DeleteUser(Long id);

   //void UpdateUser(UserEntity user);
   //UserEntity  GetUserById(long id);

}
