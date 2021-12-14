package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.domain.ProductReview;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update ProductReview c set c.isApprovedByAdmin = :isApproved where c.id = :id")
    void updateApproval(Boolean isApproved, Long id);
}
