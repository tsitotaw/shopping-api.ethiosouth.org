package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.domain.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Customer c set c.isSellerApprovedByAdmin = :isApproved where c.id = :id")
    void updateApproval(Boolean isApproved, Long id);
}
