package Skect.domain.WorkProvider;

import Skect.domain.UserPackage.CreateUserRequest;
import Skect.domain.WorkService.WorkService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProviderRequest extends CreateUserRequest {
    @NotNull
    private WorkService service;
    @NotBlank
    private String description;
}
