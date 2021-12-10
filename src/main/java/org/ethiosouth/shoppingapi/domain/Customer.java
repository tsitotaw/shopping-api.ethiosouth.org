package org.ethiosouth.shoppingapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer buyerPoints;
    private Boolean isSeller;
    private Boolean isSellerApprovedByAdmin;

    @OneToOne()
    @JoinColumn(name="shippingAddressId")
    private Address shippingAddress;

    @OneToOne()
    @JoinColumn(name="billingAddressId")
    private Address billingAddress;

}
