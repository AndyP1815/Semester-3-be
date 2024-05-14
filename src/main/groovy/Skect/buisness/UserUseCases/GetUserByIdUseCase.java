package Skect.buisness.UserUseCases;

import Skect.domain.UserPackage.GetUserByIdResponse;

public interface GetUserByIdUseCase {
    public GetUserByIdResponse GetUserById(long id);
}
