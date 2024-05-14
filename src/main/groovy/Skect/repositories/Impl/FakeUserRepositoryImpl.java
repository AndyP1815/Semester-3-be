package Skect.repositories.Impl;

import Skect.repositories.Entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeUserRepositoryImpl //implements UserRepository
{

    private List<UserEntity> savedUsers;

    private static long NEXT_ID = 4;

    public FakeUserRepositoryImpl()
    {
        savedUsers = new ArrayList<>();
        savedUsers.add(UserEntity.builder().id(1).password("Pasword123").username("Username123").build());
        savedUsers.add(UserEntity.builder().id(2).password("Pasword1234").username("Username1234").build());
        savedUsers.add(UserEntity.builder().id(3).password("Pasword12345").username("Username12345").build());

    }
    //@Override
    public List<UserEntity> GetAllUser() {
        return savedUsers;
    }

   // @Override
    public void SaveUser(UserEntity user) {

        user.setId(NEXT_ID);
        NEXT_ID++;
        this.savedUsers.add(user);
    }

    //@Override
    public void DeleteUser(Long id) {
        for (UserEntity u: savedUsers
        )if(u.getId() == id)
        {
            savedUsers.remove(u);
        }


    }

    //@Override
    public void UpdateUser(UserEntity user) {
        for (UserEntity u: savedUsers
             )if(u.getId() == user.getId()) {

            u.setPassword(user.getPassword());
            u.setUsername(user.getUsername());

        }

    }

   // @Override
    public UserEntity GetUserById(long id) {
        for (UserEntity u: savedUsers
        )if(u.getId() == id)
        {
            return u;
        }
        return null;
    }
}
