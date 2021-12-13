package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.ProductReview;
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.productReviewService.delete(id);
    }
}
