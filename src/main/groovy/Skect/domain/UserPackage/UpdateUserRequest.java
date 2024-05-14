package Skect.domain.UserPackage;

import Skect.domain.ChatPackage.Chat;
import Skect.domain.JobsPackage.Job;
import Skect.domain.NotificationPackage.Notification;
import Skect.domain.OrderPackage.Order;
import Skect.repositories.Entity.ChatEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String profilePicture;
    private List<Order> servicesOrdered;
    private List<Job> offerJobs;
    private List<Chat> chats;
    private List<Notification> notifications;

}
