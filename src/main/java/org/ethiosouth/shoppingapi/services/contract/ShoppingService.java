package org.ethiosouth.shoppingapi.services.contract;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingService<T> {
    public List<T> findAll();

    public T findById(Long id);

    public T save(T obj);

    public void update(T obj, Long id);

    public void delete(Long id);
}
