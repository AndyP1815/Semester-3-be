package Skect.domain.WorkService;
import Skect.domain.CatogoryPackage.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkService {
    private long id;
    private String name;
    private String description;
    private List<String> images;
    private List<Category> category;

}
