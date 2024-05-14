package Skect.domain.WorkService;

import Skect.domain.CatogoryPackage.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class UpdateServiceRequest {
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private List<String> images;
    private List<Category> category;
}
