package Skect.controller;


import Skect.buisness.CatogoryUseCases.CreateCategoryUseCase;
import Skect.buisness.CatogoryUseCases.GetAllCatogoriesUseCase;
import Skect.domain.CatogoryPackage.CreateCategoryRequest;
import Skect.domain.CatogoryPackage.GetAllCatogoriesResponse;
import Skect.domain.UserPackage.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catogories")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CatogoryController {

    private final GetAllCatogoriesUseCase getAllCatogoriesUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;

    @GetMapping()
    public ResponseEntity<GetAllCatogoriesResponse> getProviders() {
        return ResponseEntity.ok(getAllCatogoriesUseCase.GetAllCatogories());
    }
    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody @Valid CreateCategoryRequest request) {
        createCategoryUseCase.CreateCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
