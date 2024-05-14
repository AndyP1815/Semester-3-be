package Skect.buisness.Impl.JobUseCaseImpl;

import Skect.domain.JobsPackage.Job;
import Skect.repositories.Entity.JobEntity;
import org.springframework.stereotype.Component;

@Component
public final class JobConverter {

    private JobConverter(){

    }
    public static Job Convert(JobEntity entity){
        return Job.builder()
                .description(entity.getDescription())
                .id(entity.getId())
                .name(entity.getName()).build();

    }
    public static JobEntity ConvertToEntity(Job job){
        return JobEntity.builder()
                .description(job.getDescription())
                .id(job.getId())
                .name(job.getName()).build();

    }
}
