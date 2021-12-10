package org.ethiosouth.shoppingapi.services.implementation;

import org.ethiosouth.shoppingapi.domain.ProductCategory;
import org.ethiosouth.shoppingapi.repositories.ProductCategoryRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService implements ShoppingService<ProductCategory> {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findAll() {
        return (List<ProductCategory>) this.productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory findById(Long id) {
        return this.productCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return this.productCategoryRepository.save(productCategory);
    }

    @Override
    public void update(ProductCategory productCategory, Long id) {
        this.save(productCategory);
    }

    @Override
    public void delete(Long id) {
        this.productCategoryRepository.deleteById(id);
    }
}
