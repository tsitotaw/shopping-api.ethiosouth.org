package org.ethiosouth.shoppingapi.services.implementation;

import org.ethiosouth.shoppingapi.domain.Follower;
import org.ethiosouth.shoppingapi.repositories.FollowerRepository;
import org.ethiosouth.shoppingapi.services.contract.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService implements ShoppingService<Follower> {

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public List<Follower> findAll() {
        return (List<Follower>) this.followerRepository.findAll();
    }

    @Override
    public Follower findById(Long id) {
        return this.followerRepository.findById(id).orElse(null);
    }

    @Override
    public Follower save(Follower follower) {
        return this.followerRepository.save(follower);
    }

    @Override
    public void update(Follower follower, Long id) {
        this.save(follower);
    }

    @Override
    public void delete(Long id) {
        this.followerRepository.deleteById(id);
    }
}
