package Skect.buisness.Impl.OrderUseCaseImpl;


import Skect.domain.OrderPackage.Order;
import Skect.repositories.Entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public final class OrderConverter {

    private OrderConverter(){

    }
    public static Order Convert(OrderEntity entity){
        return Order.builder()
                .id(entity.getId())
                .status(entity.getStatus()).build();
    }
    public static OrderEntity ConvertToEntity(Order order){
        return OrderEntity.builder()
                .id(order.getId())
                .status(order.getStatus()).build();
    }
}
