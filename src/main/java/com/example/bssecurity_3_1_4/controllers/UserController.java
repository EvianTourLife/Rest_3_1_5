//package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller
//@RequestMapping("/user")
//public class UserController {

//    private final UserServiceImpl service;
//
//    public UserController(UserServiceImpl service) {
//        this.service = service;
//    }

//    @GetMapping()
//    public String getUserInfo(Model model, @AuthenticationPrincipal User user) {
//        model.addAttribute("user", user);
//        return "userInfo";
//    }

//    @GetMapping("/{id}")
//    public User getUserInfo(@PathVariable Long id) {
//        User user = service.getById(id);
//        return user;
//    }
//}
