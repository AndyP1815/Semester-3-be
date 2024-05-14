package Skect.domain.WorkProvider;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllProvidersResponse {
    List<WorkProvider> providers;
}
