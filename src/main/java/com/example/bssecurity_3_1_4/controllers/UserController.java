package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl service;

    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }
    @GetMapping()
    public String getUserInfo(Model model, Principal principal) {
        User user = (User) service.loadUserByUsername(principal.getName());
        model.addAttribute("user", service.getById(user.getId()));

        return "userInfo";
    }
}
