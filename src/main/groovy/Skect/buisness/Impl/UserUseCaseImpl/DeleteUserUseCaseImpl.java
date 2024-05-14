package Skect.buisness.Impl.UserUseCaseImpl;

import Skect.buisness.UserUseCases.DeleteUserUseCase;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {
    private final UserRepository userRepository;
    @Override
    public void deleteUser(long id) {
        Optional<UserEntity> delete = userRepository.findById(id);
        delete.ifPresent(userRepository::delete);
    }
}
