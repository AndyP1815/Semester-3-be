package Skect.domain.CatogoryPackage;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllCatogoriesResponse {
    List<Category> catogories;
}
