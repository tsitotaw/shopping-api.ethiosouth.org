package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.Follower;
import org.ethiosouth.shoppingapi.repositories.FollowerRepository;
import org.ethiosouth.shoppingapi.services.implementation.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/followers")
@CrossOrigin
public class FollowerController {

    @Autowired
    private FollowerService followerService;

    @Autowired
    private FollowerRepository followerRepository;

    @GetMapping
    public List<Follower> getAll(){
        return this.followerService.findAll();
    }

    @GetMapping("/{id}")
    public Follower get(@PathVariable Long id){
        return this.followerService.findById(id);
    }

    @PostMapping
    public Follower save(Follower follower){
        return this.followerService.save(follower);
    }

    @PutMapping("/{id}")
    public void update(Follower follower, @PathVariable Long id){
        this.followerService.update(follower, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.followerService.delete(id);
    }
}
