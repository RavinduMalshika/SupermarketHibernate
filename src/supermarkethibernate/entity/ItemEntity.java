package supermarkethibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemEntity {
    @Id
    @Column(name = "ItemCode", nullable = false, length = 6)
    private String id;

    @Column(name = "Description", nullable = false, length = 50)
    private String description;

    @Column(name = "PackSize", length = 20)
    private String packSize;

    @Column(name = "UnitPrice", nullable = false)
    private Double unitPrice;

    @Column(name = "QtyOnHand", nullable = false)
    private Integer qtyOnHand;

}
