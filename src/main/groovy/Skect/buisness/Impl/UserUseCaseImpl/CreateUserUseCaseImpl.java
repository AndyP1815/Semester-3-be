package Skect.buisness.Impl.UserUseCaseImpl;

import Skect.buisness.UserUseCases.CreateUserUseCase;
import Skect.domain.UserPackage.CreateUserRequest;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;



    @Override
    public void CreateUser(CreateUserRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .servicesOrdered(new ArrayList<>())
                .offerJobs(new ArrayList<>())
                .chats(new ArrayList<>())
                .notifications(new ArrayList<>())
                .profilePicture(request.getProfilePicture())
                .build();
        userRepository.save(userEntity);;
    }



}
