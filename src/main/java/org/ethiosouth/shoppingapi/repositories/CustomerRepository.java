package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);
}
