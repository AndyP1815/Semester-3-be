package Skect.domain.NotificationPackage;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class AcceptNotifications extends Notification{
    private Boolean Acceptance;

}
