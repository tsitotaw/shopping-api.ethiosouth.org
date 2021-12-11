package org.ethiosouth.shoppingapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="cust_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne()
    @JoinColumn(name="buyerId")
    private Customer buyer;

    @OneToOne()
    @JoinColumn(name="productId")
    private Product product;

    private LocalDate orderedDate;
    private LocalDate shippedDate;
    private LocalDate deliveredDate;
    private LocalDate cancelledDate;
    private Boolean isShipped;
    private Boolean isCancelled;
    private Boolean isDelivered;

}
