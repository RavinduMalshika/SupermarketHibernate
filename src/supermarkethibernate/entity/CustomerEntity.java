package supermarkethibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerEntity {
    @Id
    @Column(name = "CustID", nullable = false, length = 6)
    private String id;

    @Column(name = "CustTitle", length = 5)
    private String title;

    @Column(name = "CustName", nullable = false, length = 30)
    private String name;

    @Column(name = "DOB", columnDefinition = "date")
    private Date dob;

    @Column(name = "Salary", nullable = false)
    private Double salary;

    @Column(name = "Address", length = 30)
    private String address;

    @Column(name = "City", length = 20)
    private String city;

    @Column(name = "Province", length = 20)
    private String province;

    @Column(name = "PostalCode", length = 9)
    private String postalCode;

//    @OneToMany(mappedBy = "customerEntity", targetEntity = OrderEntity.class)
//    @ToString.Exclude
//    private List<OrderEntity> orderEntities;
}
