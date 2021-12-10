package org.ethiosouth.shoppingapi.services.implementation;

import org.ethiosouth.shoppingapi.domain.Order;
import org.ethiosouth.shoppingapi.repositories.OrderRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements ShoppingService<Order> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return (List<Order>) this.orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order, Long id) {
        this.save(order);
    }

    @Override
    public void delete(Long id) {
        this.orderRepository.deleteById(id);
    }
}
