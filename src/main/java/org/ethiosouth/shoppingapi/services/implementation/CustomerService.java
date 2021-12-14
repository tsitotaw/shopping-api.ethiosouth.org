package org.ethiosouth.shoppingapi.services.implementation;

import lombok.RequiredArgsConstructor;
import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.repositories.CustomerRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ShoppingService<Customer>, UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = this.customerRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Provided Email is not a valid username");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("A:"+user.getId().toString()));
        authorities.add(new SimpleGrantedAuthority("B:"+user.getRole().getName()));
        authorities.add(new SimpleGrantedAuthority("C:"+user.getRole().getPermissions()));

        authorities.add(new SimpleGrantedAuthority("D:"+ user.getIsSeller().toString()));
        authorities.add(new SimpleGrantedAuthority("E:"+ user.getIsSellerApprovedByAdmin().toString()));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }

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
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        return this.customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer, Long id) {
        Customer existingCustomer = this.customerRepository.findById(id).orElse(null);
        customer.setPassword(existingCustomer.getPassword());
        this.save(customer);
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

}
