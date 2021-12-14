package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.repositories.CustomerRepository;
import org.ethiosouth.shoppingapi.services.implementation.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAll(){
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id){
        return this.customerService.findById(id);
    }

    @PostMapping
    public Customer save(Customer customer){
        return this.customerService.save(customer);
    }

    @PutMapping("/{id}")
    public void update(Customer customer, @PathVariable Long id){
        this.customerService.update(customer, id);
    }
    @PutMapping("/approve/{id}")
    public void approve(Customer customer, @PathVariable Long id){
        this.customerRepository.updateApproval(customer.getIsSellerApprovedByAdmin(), id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.customerService.delete(id);
    }
}
