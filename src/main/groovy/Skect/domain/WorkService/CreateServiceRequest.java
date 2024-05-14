package Skect.domain.WorkService;

import Skect.domain.CatogoryPackage.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateServiceRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private List<String> images;
    private List<Category> category;
}
