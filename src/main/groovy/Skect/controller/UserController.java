package Skect.controller;

import Skect.buisness.UserUseCases.*;
import Skect.domain.UserPackage.CreateUserRequest;
import Skect.domain.UserPackage.GetAllUserResponse;
import Skect.domain.UserPackage.GetUserByIdResponse;
import Skect.domain.UserPackage.UpdateUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;


@GetMapping()
public ResponseEntity<GetAllUserResponse> getUsers() {
    return ResponseEntity.ok(getAllUsersUseCase.GetUsers());
}
@GetMapping("{id}")
public ResponseEntity<?> getUsersById(@PathVariable(value = "id") final long id){
        final GetUserByIdResponse user = getUserByIdUseCase.GetUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        deleteUserUseCase.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody @Valid CreateUserRequest request) {
        createUserUseCase.CreateUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateUserRequest request) {
        request.setId(id);
        updateUserUseCase.UpdateUser(request);
        return ResponseEntity.noContent().build();
    }
}

