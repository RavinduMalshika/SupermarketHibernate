package supermarkethibernate.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemDto {
    private String id;
    private String description;
    private String packSize;
    private Double unitPrice;
    private Integer qtyOnHand;
}
