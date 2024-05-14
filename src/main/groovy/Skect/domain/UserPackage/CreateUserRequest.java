package Skect.domain.UserPackage;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {


    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String profilePicture;

}
