package Skect.buisness.WorkServiceUSeCases;

import Skect.domain.WorkService.GetServiceByIdResponse;

public interface GetServiceByIdUseCase {
    public GetServiceByIdResponse GetServiceById(Long id);
}
