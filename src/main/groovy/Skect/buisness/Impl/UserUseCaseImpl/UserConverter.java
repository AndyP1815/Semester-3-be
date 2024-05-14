package Skect.buisness.Impl.UserUseCaseImpl;

import Skect.buisness.Impl.ChatUseCaseImpl.ChatConverter;
import Skect.buisness.Impl.JobUseCaseImpl.JobConverter;
import Skect.buisness.Impl.NotificationUseCaseImpl.NotificationConverter;
import Skect.buisness.Impl.OrderUseCaseImpl.OrderConverter;
import Skect.domain.UserPackage.User;
import Skect.repositories.Entity.UserEntity;
import org.springframework.stereotype.Component;


@Component
final class UserConverter {

    private UserConverter(){

    }
    public static User Convert(UserEntity entity){
        return User.builder().id(entity.getId())
                .password(entity.getPassword()).
        username(entity.getUsername())
                .offerJobs(entity.getOfferJobs().stream().map(JobConverter::Convert).toList())
                .servicesOrdered(entity.getServicesOrdered().stream().map(OrderConverter::Convert).toList())
                .chats(entity.getChats().stream().map(ChatConverter::Convert).toList())
                .notifications(entity.getNotifications().stream().map(NotificationConverter::Convert).toList())
                .profilePicture(entity.getProfilePicture())
                .build();

    }

}
