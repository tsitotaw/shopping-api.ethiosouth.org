package org.ethiosouth.shoppingapi.services.implementation;

import org.ethiosouth.shoppingapi.domain.Product;
import org.ethiosouth.shoppingapi.repositories.ProductRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ShoppingService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {

        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product student) {
        return this.productRepository.save(student);
    }

    @Override
    public void update(Product student, Long id) {
        this.save(student);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
