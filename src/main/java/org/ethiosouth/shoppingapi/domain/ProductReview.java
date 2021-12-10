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
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne()
    @JoinColumn(name="buyerId")
    private Customer buyerId;

    @OneToOne()
    @JoinColumn(name="productId")
    private Product productId;

    private Integer rating;
    private String description;
    private Boolean isApprovedByAdmin;
}
