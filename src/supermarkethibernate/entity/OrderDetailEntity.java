package supermarkethibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
@IdClass(OrderDetailPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailEntity {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderID", nullable = false)
    private OrderEntity orderEntity;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ItemCode", nullable = false)
    private ItemEntity itemEntity;

    @Column(name = "OrderQty", nullable = false)
    private Integer qty;

    @Column(name = "Discount")
    private Double discount;
}
