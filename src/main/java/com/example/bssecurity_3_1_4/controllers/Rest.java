package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> apiGetAllUsers() {
//        List<User> users = service.getAll();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        service.addUser(user);
        return user;
    }

    @PatchMapping("/users")
    public User update(@RequestBody User user) {
        service.edit(user);
        return user;
    }


    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "User with id " + id + " was deleted";
    }
}
