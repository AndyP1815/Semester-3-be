package Skect.buisness.Impl.UserUseCaseImpl;

import Skect.buisness.UserUseCases.GetAllUsersUseCase;
import Skect.domain.UserPackage.GetAllUserResponse;
import Skect.domain.UserPackage.User;
import Skect.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@AllArgsConstructor
public class GetAllUserUseCaseImpl implements GetAllUsersUseCase {

    private final UserRepository userRepository;

    @Override
    public GetAllUserResponse GetUsers() {
        List<User> users = userRepository.findAll()
                .stream()
                .map(UserConverter::Convert).toList();

        return GetAllUserResponse.builder().users(users).build();
    }
}
