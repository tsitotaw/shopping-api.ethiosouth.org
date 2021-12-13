package org.ethiosouth.shoppingapi.controllers;

import org.ethiosouth.shoppingapi.domain.Customer;
import org.ethiosouth.shoppingapi.domain.Role;
import org.ethiosouth.shoppingapi.services.implementation.CustomerService;
import org.ethiosouth.shoppingapi.services.implementation.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll(){
        return this.roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role getAll(@PathVariable Long id){
        return this.roleService.findById(id);
    }

    @PostMapping
    public Role save(Role role){
        return this.roleService.save(role);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Role role, @PathVariable Long id){
        this.roleService.update(role, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.roleService.delete(id);
    }
}
