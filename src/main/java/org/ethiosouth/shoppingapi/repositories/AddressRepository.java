package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.Address;
import org.ethiosouth.shoppingapi.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
