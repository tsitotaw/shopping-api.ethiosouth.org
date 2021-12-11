package org.ethiosouth.shoppingapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public ProductCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    private List<Product> products;


}
