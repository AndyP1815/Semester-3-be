package Skect.domain.WorkService;

import Skect.domain.CatogoryPackage.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetServiceByIdResponse {
    private long id;
    private String name;
    private String description;
    private List<String> images;
    private List<Category> category;
}
