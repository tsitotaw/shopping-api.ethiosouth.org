package org.ethiosouth.shoppingapi.bootstrap;

import org.ethiosouth.shoppingapi.domain.*;
import org.ethiosouth.shoppingapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrapper implements CommandLineRunner {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        Address a1 = new Address(1L, "1000 Nth St", "Fairfield", "IOWA", "52557", "USA", "+16418191369");
        Address a2 = new Address(2L, "1001 Nth St", "Fairfield", "IOWA", "52556", "USA", "+16428191369");
        this.addressRepository.save(a1);
        this.addressRepository.save(a2);

        Customer cust1 = new Customer(11L, "Alex", "Bengo", "abengo@gmail.com", "123456", 0, true, true, a1, a1);
        Customer custTwo = new Customer(21L, "Peter", "Simon", "psimon@gmail.com", "123456", 0, false, false, a2, a2);
        this.customerRepository.save(cust1);
        var buyer = this.customerRepository.save(custTwo);

        ProductCategory pc1 = new ProductCategory(5L, "Entertainment");
        ProductCategory pc2 = new ProductCategory(6L, "Educational");
        this.productCategoryRepository.save(pc1);
        this.productCategoryRepository.save(pc2);

        Product p3 = new Product(8L, 1L, "SoccerBall", 5D, 0, "default", "For Soccer Lovers", pc1);
        Product p2 = new Product(7L, 1L, "English for Beginners", 10D, 0, "default", "Learn English Easy!", pc2);
        Product p1 = new Product(41L, 1L, "X-BOX", 209D, 1, "default", "For your enjoyment --- feel free to enjoy XBOX!", pc1);
        Product p4 = new Product(46L, 1L, "FIFA", 200D, 1, "default", "For your enjoyment --- feel free to enjoy FIFA2021!", pc1);

        var product2 = this.productRepository.save(p2);
        var product3 = this.productRepository.save(p3);
        var product1 = this.productRepository.save(p1);
        var product4 = this.productRepository.save(p4);

        ProductReview pr1 = new ProductReview(10L, 5, "Best Product", true, buyer, p3);
        this.productReviewRepository.save(pr1);

        Order o1 = new Order(1L, buyer, product2, LocalDate.now(), null, null, null, false,false,false);
        Order o2 = new Order(2L, buyer, product1, LocalDate.now().minusDays(5), LocalDate.now(), null, null, true,false,false);
        Order o3 = new Order(3L, buyer, product3, LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), LocalDate.now(), null, true,false,true);
        Order o4 = new Order(4L, buyer, product4, LocalDate.now().minusDays(10), null,null, LocalDate.now(), false,true,false);
        this.orderRepository.save(o1);
        this.orderRepository.save(o2);
        this.orderRepository.save(o3);
        this.orderRepository.save(o4);
    }
}
