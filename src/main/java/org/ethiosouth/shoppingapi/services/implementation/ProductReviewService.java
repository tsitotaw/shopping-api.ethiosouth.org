package org.ethiosouth.shoppingapi.services.implementation;

import org.ethiosouth.shoppingapi.domain.ProductReview;
import org.ethiosouth.shoppingapi.repositories.ProductReviewRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewService implements ShoppingService<ProductReview> {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Override
    public List<ProductReview> findAll() {
        return (List<ProductReview>) this.productReviewRepository.findAll();
    }

    @Override
    public ProductReview findById(Long id) {
        return this.productReviewRepository.findById(id).orElse(null);
    }

    @Override
    public ProductReview save(ProductReview productReview) {
        return this.productReviewRepository.save(productReview);
    }

    @Override
    public void update(ProductReview productReview, Long id) {
        this.save(productReview);
    }

    @Override
    public void delete(Long id) {
        this.productReviewRepository.deleteById(id);
    }
}
