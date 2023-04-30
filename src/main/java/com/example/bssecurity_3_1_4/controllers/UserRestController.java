package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserServiceImpl service;

    public UserRestController(UserServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @GetMapping("/getAuthorizedUser")
    public ResponseEntity<User> getAuthorizedUserInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }
    
}
