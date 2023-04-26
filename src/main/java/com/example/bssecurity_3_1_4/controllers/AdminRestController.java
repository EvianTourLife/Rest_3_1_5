package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {


    private final UserServiceImpl service;

    public AdminRestController(UserServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAll());
    }


    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.addUser(user);
        return ResponseEntity.ok(user);
    }


    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        service.edit(user);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("User with id " + id + " was deleted");
    }

}
