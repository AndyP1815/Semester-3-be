package Skect.domain.UserPackage;

import Skect.domain.ChatPackage.Chat;
import Skect.domain.JobsPackage.Job;
import Skect.domain.NotificationPackage.Notification;
import Skect.domain.OrderPackage.Order;
import Skect.repositories.Entity.ChatEntity;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class GetUserByIdResponse {
    private String username;
    private String password;
    private String profilePicture;
    private long id;
    private List<Order> servicesOrdered;
    private List<Job> offerJobs;
    private List<Chat> chats;
    private List<Notification> notifications;

}
