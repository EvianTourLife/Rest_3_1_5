package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.Role;
import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Rest {

    private final UserServiceImpl service;

    public Rest(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAdminPage() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping("/getOneUser")
    public User getUserInfo(@AuthenticationPrincipal User user) {
        return user;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        service.addUser(user);
        return user;
    }

    @PatchMapping("/users/{id}")
    public User update(@RequestBody User user) {
        service.edit(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "User with id " + id + " was deleted";
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return service.getAllRoles();
    }

}
