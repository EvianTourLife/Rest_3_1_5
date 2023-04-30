package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.Role;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/admin/roles")
public class AdminRoleRestController {

    private final UserServiceImpl service;

    public AdminRoleRestController(UserServiceImpl service) {
        this.service = service;
    }
    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(service.getAllRoles());
    }

}
