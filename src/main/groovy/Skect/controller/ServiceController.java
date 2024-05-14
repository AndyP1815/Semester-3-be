package Skect.controller;

import Skect.buisness.WorkServiceUSeCases.*;
import Skect.domain.WorkService.CreateServiceRequest;
import Skect.domain.WorkService.GetAllServiceResponse;
import Skect.domain.WorkService.GetServiceByIdResponse;
import Skect.domain.WorkService.UpdateServiceRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ServiceController {
    private final CreateServiceUseCase createServiceUseCase;
    private final GetAllServicesUseCase getAllServicesUseCase;
    private final GetServiceByIdUseCase getServiceByIdUseCase;
    private final DeleteServiceUseCase deleteServiceUseCase;
    private final UpdateServiceUseCase updateServiceUseCase;

    @GetMapping()
    public ResponseEntity<GetAllServiceResponse> getServices() {
        return ResponseEntity.ok(getAllServicesUseCase.GetServices());
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getServicesById(@PathVariable(value = "id") final long id){
        final GetServiceByIdResponse Service = getServiceByIdUseCase.GetServiceById(id);
        if(Service == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(Service);
    }

    @DeleteMapping("{ServiceId}")
    public ResponseEntity<Void> deleteService(@PathVariable int ServiceId) {
        deleteServiceUseCase.DeleteSercvice(ServiceId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Void> createService(@RequestBody @Valid CreateServiceRequest request) {
        createServiceUseCase.CreateService(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateServiceRequest request) {
        request.setId(id);
        updateServiceUseCase.UpdateService(request);
        return ResponseEntity.noContent().build();
    }
}
