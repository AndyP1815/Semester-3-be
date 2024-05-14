package Skect.domain.WorkProvider;


import Skect.domain.OrderPackage.Order;
import Skect.domain.UserPackage.User;
import Skect.domain.WorkService.WorkService;
import Skect.repositories.Entity.OrderEntity;
import Skect.repositories.Entity.WorkServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WorkProvider extends User {

    private WorkService service;
    private String description;
    private List<Order> workOrders;


}
