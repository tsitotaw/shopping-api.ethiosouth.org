package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.domain.ProductReview;
import org.ethiosouth.shoppingapi.repositories.ProductReviewRepository;
import org.ethiosouth.shoppingapi.services.implementation.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productreviews")
@CrossOrigin
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @GetMapping
    public List<ProductReview> getAll(){
        return this.productReviewService.findAll();
    }

    @GetMapping("/{id}")
    public ProductReview getAll(@PathVariable Long id){
        return this.productReviewService.findById(id);
    }

    @PostMapping
    public ProductReview save(@RequestBody ProductReview productReview){
        return this.productReviewService.save(productReview);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ProductReview productReview, @PathVariable Long id){
        this.productReviewService.update(productReview, id);
    }

    @PutMapping("/review/{id}")
    public void review(ProductReview pReview, @PathVariable Long id){
        this.productReviewRepository.updateApproval(true, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.productReviewService.delete(id);
    }
}
