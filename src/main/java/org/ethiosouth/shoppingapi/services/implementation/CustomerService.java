package org.ethiosouth.shoppingapi.services.implementation;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.repositories.CustomerRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ShoppingService<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer, Long id) {
        this.save(customer);
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }
}
