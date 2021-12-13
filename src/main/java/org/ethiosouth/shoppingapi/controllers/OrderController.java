package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.Order;
import org.ethiosouth.shoppingapi.services.implementation.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return this.orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getAll(@PathVariable Long id){
        return this.orderService.findById(id);
    }

    @PostMapping
    public Order save(@RequestBody Order order){
        return this.orderService.save(order);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Order order, @PathVariable Long id){
        this.orderService.update(order, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.orderService.delete(id);
    }
}
