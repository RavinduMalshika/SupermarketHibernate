package supermarkethibernate.service.custom;

import supermarkethibernate.dto.OrderDto;
import supermarkethibernate.service.SuperService;

public interface OrderService extends SuperService {
    String placeOrder(OrderDto orderDto);
}
