package supermarkethibernate.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailDto {
    private String itemID;
    private Integer qty;
    private Double discount;
}
