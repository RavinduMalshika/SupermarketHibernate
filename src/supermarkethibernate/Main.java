package supermarkethibernate;

import supermarkethibernate.dto.CustomerDto;
import supermarkethibernate.dto.OrderDetailDto;
import supermarkethibernate.dto.OrderDto;
import supermarkethibernate.service.ServiceFactory;
import supermarkethibernate.service.custom.CustomerService;
import supermarkethibernate.service.custom.OrderService;
import supermarkethibernate.service.custom.impl.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderID("D064");
        orderDto.setCustID("C002");

        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        orderDetailDtos.add(new OrderDetailDto("P002", 10, 0.0));
        orderDetailDtos.add(new OrderDetailDto("P010", 5, 0.0));

        orderDto.setOrderDetailDtos(orderDetailDtos);

        String resp = orderService.placeOrder(orderDto);

        System.out.println(resp);
    }
}
