package Skect.repositories.Entity;

import Skect.domain.ChatPackage.Chat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserEntity {

    private String username;
    private String password;
    private String profilePicture;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @OneToMany
    private List<OrderEntity> servicesOrdered;

    @OneToMany
    private List<JobEntity> offerJobs;

    @ManyToMany
    @JoinTable(
            name = "user_chat",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id")
    )
    private List<ChatEntity> chats;

    @OneToMany
    private List<NotificationsEntity> notifications;
}
