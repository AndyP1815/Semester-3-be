package Skect.repositories.Entity;

import Skect.domain.OrderPackage.Order;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_provider")
@Entity
public class WorkProviderEntity extends UserEntity {
    @OneToOne
    private WorkServiceEntity service;
    private String description;

    @OneToMany
    private List<OrderEntity> workOrders;

    }

