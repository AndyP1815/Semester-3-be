package Skect.domain.WorkService;

import Skect.domain.WorkService.WorkService;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllServiceResponse {
    private List<WorkService> services;
}
