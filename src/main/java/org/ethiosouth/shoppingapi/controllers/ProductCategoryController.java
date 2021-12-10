package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.ProductCategory;
import org.ethiosouth.shoppingapi.services.implementation.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCategories")
@CrossOrigin
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategory> getAll(){
        return this.productCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ProductCategory getAll(@PathVariable Long id){
        return this.productCategoryService.findById(id);
    }

    @PostMapping
    public ProductCategory save(@RequestBody ProductCategory productCategory){
        return this.productCategoryService.save(productCategory);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ProductCategory productCategory, @PathVariable Long id){
        this.productCategoryService.update(productCategory, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.productCategoryService.delete(id);
    }
}
