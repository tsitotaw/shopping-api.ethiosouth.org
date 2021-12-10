package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.Product;
import org.ethiosouth.shoppingapi.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
