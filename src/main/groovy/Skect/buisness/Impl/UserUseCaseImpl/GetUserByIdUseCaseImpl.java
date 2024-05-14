package Skect.buisness.Impl.UserUseCaseImpl;

import Skect.buisness.Impl.ChatUseCaseImpl.ChatConverter;
import Skect.buisness.Impl.JobUseCaseImpl.JobConverter;
import Skect.buisness.Impl.NotificationUseCaseImpl.NotificationConverter;
import Skect.buisness.Impl.OrderUseCaseImpl.OrderConverter;
import Skect.buisness.UserUseCases.GetUserByIdUseCase;
import Skect.domain.UserPackage.GetUserByIdResponse;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {
    private final UserRepository userRepository;
    @Override
    public GetUserByIdResponse GetUserById(long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isPresent())
        {
            return GetUserByIdResponse.builder()
                    .username(userEntity.get().getUsername())
                    .id(userEntity.get().getId())
                    .password(userEntity.get().getPassword())
                    .offerJobs(userEntity.get().getOfferJobs().stream().map(JobConverter::Convert).toList())
                    .servicesOrdered(userEntity.get().getServicesOrdered().stream().map(OrderConverter::Convert).toList())
                    .chats(userEntity.get().getChats().stream().map(ChatConverter::Convert).toList())
                    .notifications(userEntity.get().getNotifications().stream().map(NotificationConverter::Convert).toList())
                    .profilePicture(userEntity.get().getProfilePicture())
                    .build();
        }
        else {
            throw new IllegalArgumentException("User with ID " + id + " not found");
        }
    }

}
