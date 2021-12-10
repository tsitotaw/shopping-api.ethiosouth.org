package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
