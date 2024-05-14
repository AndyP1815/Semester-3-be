package Skect.buisness.Impl.MessagesUseCaseImpl;

import Skect.domain.ChatPackage.Chat;
import Skect.domain.JobsPackage.Job;
import Skect.domain.MessagesPackage.Messages;
import Skect.repositories.Entity.ChatEntity;
import Skect.repositories.Entity.JobEntity;
import Skect.repositories.Entity.MessageEntity;
import org.apache.logging.log4j.message.Message;

public final class MessageConverter {
    private MessageConverter()
    {

    }
    public static Messages Convert(MessageEntity entity){
        return Messages.builder()
                .message(entity.getMessage())
                .id(entity.getId())
                .timeStamp(entity.getDate())
                .build();

    }
    public static MessageEntity ConvertToEntity(Messages messages){
        return MessageEntity.builder()
                .message(messages.getMessage())
                .id(messages.getId())
                .date(messages.getTimeStamp())
                .build();

    }
}
