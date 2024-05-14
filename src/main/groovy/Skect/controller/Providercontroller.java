package Skect.controller;

import Skect.buisness.ProviderUseCases.UpdateProviderUseCase;
import Skect.buisness.ProviderUseCases.*;
import Skect.domain.WorkProvider.CreateProviderRequest;
import Skect.domain.WorkProvider.GetAllProvidersResponse;
import Skect.domain.WorkProvider.GetProviderByIdResponse;
import Skect.domain.WorkProvider.UpdateProviderRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/providers")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class Providercontroller {
 
        private final CreateProviderUseCase createProviderUseCase;
        private final GetAllProvidersUseCase getAllProvidersUseCase;
        private final GetProviderByIdUseCase getProviderByIdUseCase;
        private final DeleteProviderUseCase deleteProviderUseCase;
        private final UpdateProviderUseCase updateProviderUseCase;

        @GetMapping()
        public ResponseEntity<GetAllProvidersResponse> getProviders() {
            return ResponseEntity.ok(getAllProvidersUseCase.GetAllProviders());
        }
        @GetMapping("{id}")
        public ResponseEntity<?> getProvidersById(@PathVariable(value = "id") final long id){
            final GetProviderByIdResponse Provider = getProviderByIdUseCase.GetProviderById(id);
            if(Provider == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(Provider);
        }

        @DeleteMapping("{ProviderId}")
        public ResponseEntity<Void> deleteProvider(@PathVariable int ProviderId) {
            deleteProviderUseCase.DeleteProvider(ProviderId);
            return ResponseEntity.noContent().build();
        }

        @PostMapping()
        public ResponseEntity<Void> createProvider(@RequestBody @Valid CreateProviderRequest request) {
            createProviderUseCase.CreateProvider(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        @PutMapping("{id}")
        public ResponseEntity<Void> updateStudent(@PathVariable("id") long id,
                                                  @RequestBody @Valid UpdateProviderRequest request) {
            request.setId(id);
            updateProviderUseCase.UpdateProvider(request);
            return ResponseEntity.noContent().build();
        }
    }
