package Skect.buisness.Impl.UserUseCaseImpl;

import Skect.buisness.Impl.ChatUseCaseImpl.ChatConverter;
import Skect.buisness.Impl.JobUseCaseImpl.JobConverter;
import Skect.buisness.Impl.NotificationUseCaseImpl.NotificationConverter;
import Skect.buisness.Impl.OrderUseCaseImpl.OrderConverter;
import Skect.buisness.UserUseCases.UpdateUserUseCase;
import Skect.domain.UserPackage.UpdateUserRequest;
import Skect.repositories.Entity.UserEntity;
import Skect.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository userRepository;


    @Override
    public void UpdateUser(UpdateUserRequest request) {

        UserEntity user =
                UserEntity.builder()
                        .id(request.getId()).
                        password(request.getPassword())
                        .username(request.getUsername())
                        .offerJobs(request.getOfferJobs().stream().map(JobConverter::ConvertToEntity).toList())
                        .servicesOrdered(request.getServicesOrdered().stream().map(OrderConverter::ConvertToEntity).toList())
                        .chats(request.getChats().stream().map(ChatConverter::ConvertToEntity).toList())
                        .notifications(request.getNotifications().stream().map(NotificationConverter::ConvertToEntity).toList())
                        .profilePicture(request.getProfilePicture()).build();

        userRepository.save(user);
    }

}
