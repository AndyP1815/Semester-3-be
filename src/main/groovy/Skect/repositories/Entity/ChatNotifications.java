package Skect.repositories.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_notifications")
public class ChatNotifications extends AcceptNotificationsEntity{
    @OneToOne
    @JoinColumn(name = "chat_id")
    private ChatEntity chat;
}
