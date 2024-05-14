package Skect.domain.WorkProvider;

import Skect.domain.OrderPackage.Order;
import Skect.domain.UserPackage.UpdateUserRequest;
import Skect.domain.WorkService.WorkService;
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
public class UpdateProviderRequest extends UpdateUserRequest {
    private WorkService service;
    private String description;
    private List<Order> workOrders;
}
