package Skect.domain.ChatPackage;

import Skect.domain.MessagesPackage.Messages;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private long id;
    private List<Messages> messages;
}
