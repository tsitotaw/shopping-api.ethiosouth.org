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
public class Follower {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long sellerId;
}
