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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sellerId;
    private String name;
    private Double price;
    private Integer offeredPoints;
    private String img;
    private String Description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cateoryId")
    private ProductCategory category;
}
