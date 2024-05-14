package Skect.buisness.Impl.ChatUseCaseImpl;

import Skect.buisness.Impl.MessagesUseCaseImpl.MessageConverter;
import Skect.domain.ChatPackage.Chat;
import Skect.domain.JobsPackage.Job;
import Skect.repositories.Entity.ChatEntity;
import Skect.repositories.Entity.JobEntity;
import org.springframework.stereotype.Component;

@Component
public final class ChatConverter {

    private ChatConverter()
    {

    }
    public static Chat Convert(ChatEntity entity){
        return Chat.builder()
                .id(entity.getId())
                .messages(entity.getMessages().stream().map(MessageConverter::Convert).toList())
                .build();

    }
    public static ChatEntity ConvertToEntity(Chat chat){
        return ChatEntity.builder()
                .id(chat.getId())
                .messages(chat.getMessages().stream().map(MessageConverter::ConvertToEntity).toList())
                .build();

    }
}
