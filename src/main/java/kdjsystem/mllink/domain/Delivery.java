package kdjsystem.mllink.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {
    @Column(name="delivery_id")
    @Id @GeneratedValue
    private Long id;


    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)  // ORDINAL alue 로 들어감.
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;

}
