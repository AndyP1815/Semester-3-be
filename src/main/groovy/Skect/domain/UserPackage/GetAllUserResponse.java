package Skect.domain.UserPackage;

import Skect.domain.UserPackage.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllUserResponse {
    private List<User> users;
}
