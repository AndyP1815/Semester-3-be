package Skect.domain.WorkProvider;

import Skect.domain.OrderPackage.Order;
import Skect.domain.UserPackage.GetUserByIdResponse;
import Skect.domain.WorkService.WorkService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class GetProviderByIdResponse extends GetUserByIdResponse {

    private WorkService service;
    private String description;
    private List<Order> workOrders;

    }

