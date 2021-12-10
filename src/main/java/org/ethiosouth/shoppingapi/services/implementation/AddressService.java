package org.ethiosouth.shoppingapi.services.implementation;

import org.ethiosouth.shoppingapi.domain.Address;
import org.ethiosouth.shoppingapi.domain.Product;
import org.ethiosouth.shoppingapi.repositories.AddressRepository;
import org.ethiosouth.shoppingapi.repositories.ProductRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements ShoppingService<Address> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return (List<Address>) this.addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return this.addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public void update(Address address, Long id) {
        this.save(address);
    }

    @Override
    public void delete(Long id) {
        this.addressRepository.deleteById(id);
    }
}
