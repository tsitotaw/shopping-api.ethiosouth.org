package org.ethiosouth.shoppingapi.bootstrap;

import org.ethiosouth.shoppingapi.domain.*;
import org.ethiosouth.shoppingapi.repositories.*;
import org.ethiosouth.shoppingapi.services.implementation.CustomerService;
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
    private CustomerService customerService;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        Address a1 = new Address(1L, "1000 Nth St", "Fairfield", "IOWA", "52557", "USA", "+16418191369");
        Address a2 = new Address(2L, "1001 Nth St", "Fairfield", "IOWA", "52556", "USA", "+16428191369");
        this.addressRepository.save(a1);
        this.addressRepository.save(a2);

        Role r2 = new Role(2L, "BUYER", "productview,order,productreview,");
        Role r3 = new Role(3L, "SELLER","productadd,productview");
        Role r1 = new Role(98L, "ADMIN","productview,reviewapprove,sellerapprove,order,productreview");

        Role admin = this.roleRepository.save(r1);
        Role buyer = this.roleRepository.save(r2);
        Role seller = this.roleRepository.save(r3);

        Customer adminC = new Customer(8L, "Admin", "Admin", "aadmin@gmail.com", "admin", 0, false, false, a1, a1, admin);
        Customer cust1 = new Customer(11L, "Alex", "Bengo", "abengo@gmail.com", "123456", 0, true, true, a1, a1, seller);
        Customer cust11 = new Customer(122L, "Alex2", "Bengo2", "abengo2@gmail.com", "123456", 0, true, false, a1, a1, seller);
        Customer custTwo = new Customer(21L, "Peter", "Simon", "psimon@gmail.com", "123456", 0, false, false, a2, a2, buyer);
        this.customerService.save(adminC);
        this.customerService.save(cust1);
        this.customerService.save(cust11);
        var buyerCustomer = this.customerService.save(custTwo);

        ProductCategory pc1 = new ProductCategory(null, "Entertainment");
        ProductCategory pcObj1 = this.productCategoryRepository.save(pc1);

        ProductCategory pc2 = new ProductCategory(null, "Educational");
        ProductCategory pcObj2 = this.productCategoryRepository.save(pc2);

        Product p3 = new Product(8L, 1L, "Blue Jean Jacket", 5D, 0, "https://i.ibb.co/mJS6vz0/blue-jean-jacket.png", "For Soccer Lovers", pcObj1);
        Product p2 = new Product(7L, 1L, "Blue Beanie", 10D, 0, "https://i.ibb.co/ypkgK0X/blue-beanie.png", "Learn English Easy!", pcObj2);
        Product p1 = new Product(41L, 1L, "Brown Brim", 209D, 1, "https://i.ibb.co/ZYW3VTp/brown-brim.png", "For your enjoyment --- feel free to enjoy XBOX!", pcObj1);
        Product p4 = new Product(46L, 1L, "Adidas Yeezy", 200D, 1, "https://i.ibb.co/dJbG1cT/yeezy.png", "For your enjoyment --- feel free to enjoy FIFA2021!", pcObj1);

        var product2 = this.productRepository.save(p2);
        var product3 = this.productRepository.save(p3);
        var product1 = this.productRepository.save(p1);
        var product4 = this.productRepository.save(p4);

        ProductReview pr1 = new ProductReview(10L, 5, "Best Product", true, buyerCustomer, product3);
        ProductReview pr2 = new ProductReview(15L, 3, "Nice Product", false, buyerCustomer, product3);
        this.productReviewRepository.save(pr1);
        this.productReviewRepository.save(pr2);

        Order o1 = new Order(1L, buyerCustomer, product2, LocalDate.now(), null, null, null, false,false,false);
        Order o2 = new Order(2L, buyerCustomer, product1, LocalDate.now().minusDays(5), LocalDate.now(), null, null, true,false,false);
        Order o3 = new Order(3L, buyerCustomer, product3, LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), LocalDate.now(), null, true,false,true);
        Order o4 = new Order(4L, buyerCustomer, product4, LocalDate.now().minusDays(10), null,null, LocalDate.now(), false,true,false);
        this.orderRepository.save(o1);
        this.orderRepository.save(o2);
        this.orderRepository.save(o3);
        this.orderRepository.save(o4);
    }
}
