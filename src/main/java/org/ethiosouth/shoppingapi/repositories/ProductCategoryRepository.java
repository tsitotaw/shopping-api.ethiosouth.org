package org.ethiosouth.shoppingapi.repositories;

import org.ethiosouth.shoppingapi.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
