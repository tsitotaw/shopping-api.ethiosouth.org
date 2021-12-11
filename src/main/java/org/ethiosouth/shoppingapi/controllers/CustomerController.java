package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.services.implementation.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll(){
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getAll(@PathVariable Long id){
        return this.customerService.findById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return this.customerService.save(customer);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Customer customer, @PathVariable Long id){
        this.customerService.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.customerService.delete(id);
    }
}
