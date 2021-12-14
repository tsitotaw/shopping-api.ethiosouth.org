package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.Product;
import org.ethiosouth.shoppingapi.services.implementation.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getAll(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @PostMapping
    public Product save(Product product){
        return this.productService.save(product);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Product product, @PathVariable Long id){
        this.productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.productService.delete(id);
    }
}
