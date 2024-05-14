package Skect.domain.CatogoryPackage;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {
    private String name;
    private String description;
    private String imageUrl;
}
