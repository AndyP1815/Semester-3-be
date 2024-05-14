package Skect.buisness.Impl.WorkServiceUseCaseImpl;


import Skect.domain.WorkService.WorkService;
import Skect.repositories.Entity.WorkServiceEntity;
import org.springframework.stereotype.Component;

@Component
public final class WorkServiceConverter {
    private WorkServiceConverter(){

    }
    public static WorkService Convert(WorkServiceEntity service){
        return WorkService.builder().
                id(service.getId()).
                description(service.getDescription()).
                name(service.getName()).build();

    }
    public static WorkServiceEntity Convert2(WorkService service){
        return WorkServiceEntity.builder().
                id(service.getId()).
                description(service.getDescription()).
                name(service.getName()).build();

    }
}
