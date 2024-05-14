package Skect.buisness.Impl.NotificationUseCaseImpl;

import Skect.domain.MessagesPackage.Messages;
import Skect.domain.NotificationPackage.Notification;
import Skect.repositories.Entity.MessageEntity;
import Skect.repositories.Entity.NotificationsEntity;

public final class NotificationConverter {

    private NotificationConverter()
    {

    }
    public static Notification Convert(NotificationsEntity entity){
        return Notification.builder()
                .message(entity.getMessage())
                .id(entity.getId())
                .name(entity.getName())
                .dateStamp(entity.getTimeStamp()).build();

    }
    public static NotificationsEntity ConvertToEntity(Notification notification){
        return NotificationsEntity.builder()
                .message(notification.getMessage())
                .id(notification.getId())
                .name(notification.getName())
                .timeStamp(notification.getDateStamp()).build();

    }
}
