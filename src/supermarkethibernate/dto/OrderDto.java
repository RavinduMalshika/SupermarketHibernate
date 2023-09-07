package supermarkethibernate.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {
    private String orderID;
    private String custID;
    private List<OrderDetailDto> orderDetailDtos;
}
